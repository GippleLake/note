package com.gipplelake.thinking_in_java.generics.mixin.Interface;

import java.util.Date;

/**
 * 使用接口完成混型
 * @author dengqg
 */
public  interface TimeStamped {
    long getStamp();
}

class TimeStampedImp implements TimeStamped {
    private final long timeStamp;
     TimeStampedImp() {
        timeStamp = new Date().getTime();
    }
    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered {
    long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Basic {
     void set(String val);
     String get();
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

class Mixmin extends BasicImp implements TimeStamped, SerialNumbered {
    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();
    public long getStamp() {
        return timeStamp.getStamp();
    }
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }
}

 class Mixmins {
    public static void main (String... args) {
        Mixmin mixmin1 = new Mixmin(), mixmin2 = new Mixmin();
        mixmin1.set("string1");
        mixmin2.set("string2");
        System.out.println(mixmin1.get() + "  " + mixmin1.getStamp() + "  " + mixmin1.getSerialNumber());
        System.out.println(mixmin2.get() + "  " + mixmin2.getStamp() + "  " + mixmin2.getSerialNumber());
    }
}