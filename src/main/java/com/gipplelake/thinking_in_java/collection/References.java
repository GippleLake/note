package com.gipplelake.thinking_in_java.collection;

import java.lang.ref.*;
import java.util.LinkedList;

/**
 * 当存在可能会耗尽内存的大对象时,可以使用继承自Reference的三个类SoftReference,WeakReference,PhantomReference.
 * 具体查看 http://www.cnblogs.com/skywang12345/p/3154474.html
 * @author dengqg
 */
public class References {

    //引用队列;如果引用的对象被垃圾回收,jvm会把这个引用添加到与之关联的引用队列中
    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();

    public static void checkQueue() {
        Reference<? extends VeryBig> inq = rq.poll();
        if (inq != null) {
            System.out.println("In queue:" + inq.get());
        }
    }

    public static void main(String[] args) {
        int size = 10;
        if (args.length > 0) {
            size = new Integer(args[0]);
        }
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<SoftReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            sa.add(new SoftReference<VeryBig>(new VeryBig("Soft" + i), rq));
        }
        System.out.println("Just created:" + sa.getLast());
        checkQueue();

        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<WeakReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            wa.add(new WeakReference<VeryBig>(new VeryBig("Weak" + i), rq));
        }
        System.out.println("Just created:" + wa.getLast());
        checkQueue();

        SoftReference<VeryBig> s = new SoftReference<VeryBig>(new VeryBig("Soft"));
        WeakReference<VeryBig> w = new WeakReference<VeryBig>(new VeryBig("Weak"));
        System.gc();

        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<PhantomReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            pa.add(new PhantomReference<VeryBig>(new VeryBig("Phantom" + i), rq));
        }
        System.out.println("Just created:" + pa.getLast());
        checkQueue();
    }
}

class VeryBig {
    private static final int SIZE = 100;
    private long[] la = new long[SIZE];
    private String ident;

    public VeryBig(String id) {
        ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " + ident);
    }
}
