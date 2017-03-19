package com.gipplelake.thinking_in_java.generics;

/**
 * 可以使用泛型创建元组（tuple），使方法返回多个不同类型参数
 *
 * @author dengqg
 */
public class TowTuple<T, S> {
    public final T t;
    public final S s;

    public TowTuple(T t, S s) {
        this.t = t;
        this.s = s;
    }

    //简化创建语句
    public static <T, S> TowTuple<T, S> create(T t, S s) {
        return new TowTuple<T, S>(t, s);
    }

    @Override
    public String toString() {
        return "TowTuple{" +
                "t=" + t +
                ", s=" + s +
                '}';
    }
}


class ThreeTuple<T, S, K> extends TowTuple<T, S> {
    public final K k;

    public ThreeTuple(T t, S s, K k) {
        super(t, s);
        this.k = k;
    }

    @Override
    public String toString() {
        return "ThreeTuple{" +
                "k=" + k +
                "} " + super.toString();
    }

    static TowTuple<Integer, String> f() {
        return TowTuple.create(1,"1123");
    }

    static ThreeTuple<Integer, String, Boolean> f2() {
        return new ThreeTuple<Integer, String, Boolean>(1, "1234", false);
    }

    public static void main(String[] args) {
        System.out.println(f());
        System.out.println(f2());

    }

}
