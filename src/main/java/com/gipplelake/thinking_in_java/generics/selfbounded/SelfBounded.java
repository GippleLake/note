package com.gipplelake.thinking_in_java.generics.selfbounded;

/**
 * 枚举就是基于自限定类型
 * http://www.angelikalanger.com/GenericsFAQ/FAQSections/TypeParameters.html#FAQ106
 * 自限定类型只能由子类初始化,并且子类可以复用父类的方法,这些方法的参数或返回类型又依赖于子类
 * T extends SelfBounded<T>规定子类只能是 X extend SelfBounded<X> ,不能是X extend SelfBounded<Y>,
 * X extend SelfBounded<Y>这样做的话,父类的泛型方法将不依赖X而是依赖于Y,X的实例调用compareTo等方法也就失去了意思
 */
public class SelfBounded<T extends SelfBounded<T>> implements Comparable<T>{
    T element;
    SelfBounded<T> set(T arg){
        element = arg;
        return this;
    }
    T get(){
        return element;
    }

    public int compareTo(T o) {
        return 0;
    }
}

//最常用的做法
class A extends SelfBounded<A>{

}
//允许这么做,因为A满足自限定,不常用
class B extends SelfBounded<A>{


}

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}
class  D extends SelfBounded{}
//不允许这么做,D只是SelfBounded的子类,但不满足自限定
//class E extends SelfBounded<D>{}
class F extends SelfBounded{
    @Override
    SelfBounded set(SelfBounded arg) {
        return super.set(arg);
    }
}
 class SelfBounding{
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();
        C c = new C();
        c = c.setAndGet(new C());

        B b = new B();
        b.set(new A());
    }
}

class SelfBoundedMethod{
    static <T extends SelfBounded<T>> T f(T arg){
        return arg.set(arg).get();
    }

    public static void main(String[] args) {
        A a = f(new A());
        B b = new B();
        b.set(new A());
    }

}