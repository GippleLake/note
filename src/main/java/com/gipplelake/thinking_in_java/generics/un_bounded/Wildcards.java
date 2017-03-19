package com.gipplelake.thinking_in_java.generics.un_bounded;

/**
 * @author dengqg
 * <?>较之原生类型,可以将不安全的隐患从warning升级到error
 */
public class Wildcards {


    static void rawArgs(Holder holder, Object arg) {
        //编译器知道holder是泛型类型，所以set是不安全的，get也只能向上转型成Object
        holder.set(arg);
        holder.set(new Wildcards());
      //  T t = holder.get();
        Object o = holder.get();
    }

//Holder<?> 持有具有某种具体类型的同构集合，Holder是持有任何类型的集合
    static void unBoundedArg(Holder<?> holder, Object arg) {
        //set时抛错而不是warning,不能向其中添加object
        // holder.set(arg);
        Object o = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    //如果T是Fruit那么holder可以是Holder<Apple>,为了不让Orange放到Holder<Apple>中
    //所以不允许set，但是你仍然知道Holder<? extends Fruit>至少是Fruit，所以允许get
    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        // holder.set(arg);
        T t = holder.get();
        return t;
    }

    //holder可以持有任何T的基类型容器，因此set可以接受T，任何工作于基类的对象都可以多态的
    //作用于导出类;由holder持有的可以是任何的超类型,所以get类型只能是Object
    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);
//        T t= holder.get();
        Object o = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder();
        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();

        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1L;
        rawArgs(raw,lng);
        rawArgs(qualified,lng);
        rawArgs(unbounded,lng);
        rawArgs(bounded,lng);
        unBoundedArg(raw,lng);
        unBoundedArg(qualified,lng);
        unBoundedArg(unbounded,lng);
        unBoundedArg(bounded,lng);

        Object r1 = exact1(raw);
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded);
        Long r4 = exact1(bounded);
        Object r5 = exact2(raw,lng);
        Long r6 = exact2(qualified,lng);
//        Long r7 = exact2(unbounded,lng);
//        Long r8 = exact2(bounded,lng);
      Object r9 = wildSubtype(raw,lng);

        Long r10 = wildSubtype(qualified,lng);
       // Object r11 = wildSubtype(unbounded,lng);
        Long r12 = wildSubtype(bounded,lng);
        wildSupertype(raw,lng);
        wildSupertype(qualified,lng);
        // wildSupertype(bounded,lng);
        // wildSupertype(unbounded,lng);
        Holder<Object> holder= new Holder<Object>();
       wildSupertype(holder,lng);



    }


}
