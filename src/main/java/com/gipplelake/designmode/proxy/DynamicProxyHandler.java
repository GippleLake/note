package com.gipplelake.designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dengqg
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy:" + proxy.getClass() + ", method: " + method);
        if (args != null) {
            for (Object arg : args) {
                System.out.println("args  " + arg);
            }
        }
        return method.invoke(proxied, args);
    }
}

class SimpleDynamicProxy {
    public static void consumer(DoWhat doWhat) {
        doWhat.doSomething();
        doWhat.somethingElse("boob");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);
        DoWhat proxy = (DoWhat) Proxy.newProxyInstance(DoWhat.class.getClassLoader(), new Class[]{DoWhat.class},
                new DynamicProxyHandler(realObject));
        consumer(proxy);
    }
}
