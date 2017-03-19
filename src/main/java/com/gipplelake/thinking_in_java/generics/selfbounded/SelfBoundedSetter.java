package com.gipplelake.thinking_in_java.generics.selfbounded;

/**
 * @author dengqg
 */
 interface SelfBoundedSetter <T extends SelfBoundedSetter<T>>{
     void set(T arg);
}
interface Setter extends SelfBoundedSetter<Setter>{
     void set(Integer arg);
}

 class SelfBoundingAndCovariantArguments{
     void test(Setter s1,Setter s2,Integer i,SelfBoundedSetter sbs,SelfBoundedSetter sbs2){
         s1.set(s2);
         s1.set(i);
       //  s1.set(sbs);
         sbs.set(sbs2);

     }
}
