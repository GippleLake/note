package com.gipplelake.thinking_in_java.RTTI;

/**
 * @author dengqg
 */
public class Test {

    public static void main(String[] args) {
        try {
            Class c = Class.forName("com.gipplelake.designmode.adapter.one.Source");
            Object instance = c.newInstance();
            System.out.println(instance);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
