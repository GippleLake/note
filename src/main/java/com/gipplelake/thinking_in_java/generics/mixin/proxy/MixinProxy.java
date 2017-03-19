package com.gipplelake.thinking_in_java.generics.mixin.proxy;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 可以使用动态代理创建一种比装饰器更贴近模型的机制,所产生的类的动态类型将是混合类型
 * @author dengqg
 */
class TwoTuple<T, S> {
    T first;
    S second;

     TwoTuple(T t, S s) {
        this.first = t;
        this.second = s;
    }
}


class BasicImp implements Basic {
    private String value;

    public void set(String val) {
        this.value = val;
    }

    public String get() {
        return value;
    }
}

class TimeStampedImp implements TimeStamped {
    private final long timeStamp = new Date().getTime();
    public long getTimeStamp() {
        return timeStamp;
    }
}

class SerialNumberedImp implements SerialNumbered   {
    private static long counter = 1;
    private final long serialNumber = counter++;


    public long getSerialNumber() {
        return serialNumber;
    }

}

class MixminProxy implements InvocationHandler {
    Map<String, Object> delegatesByMethod;

     MixminProxy(TwoTuple<Object, Class<?>>... pairs) {
        delegatesByMethod = new HashMap<String, Object>();
        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {
                String methodName = method.getName();
                if (!delegatesByMethod.containsKey(methodName))
                    delegatesByMethod.put(methodName, pair.first);
            }
        }
    }

     static Object newInstance(TwoTuple... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].second;
        }
        ClassLoader cl = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(cl, interfaces, new MixminProxy(pairs));
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }
}

 class DynamicProxyMixmin {
    public static void main(String... args) {
        Object mixmin = MixminProxy.newInstance(
                tuple(new BasicImp(), Basic.class),
                tuple(new TimeStampedImp(), TimeStamped.class),
                tuple(new SerialNumberedImp(), SerialNumbered.class));
        Basic b = (Basic) mixmin;
        TimeStamped t = (TimeStamped) mixmin;
        SerialNumbered s = (SerialNumbered) mixmin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getTimeStamp());
        System.out.println(s.getSerialNumber());
    }

    static <T, S> TwoTuple<T, S> tuple(T t, S s) {
        return new TwoTuple<T, S>(t, s);
    }
}