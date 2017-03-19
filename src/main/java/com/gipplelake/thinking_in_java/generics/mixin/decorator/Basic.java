package com.gipplelake.thinking_in_java.generics.mixin.decorator;

import java.util.Date;

/**
 *
 对于装饰器来说，其明显的缺陷在于它只能有效地工作于装饰中的最后一层,最后一层才是实际的类型
  而混型的类型应该是所有被混合在一起的类型,所以装饰器只是对混型的一种局限的解决方案
 * @author dengqg
 */
class Basic {
    private String value;

    public void set(String val) {
        this.value = val;
    }

    public String get() {
        return value;
    }
}

class Decorator extends Basic {
    protected Basic basic;

    public Decorator(Basic basic) {
        this.basic = basic;
    }

    public void set(String val) {
        basic.set(val);
    }

    public String get() {
        return basic.get();
    }
}

class TimeStamped extends Decorator {
    private final long timeStamp;

    public TimeStamped(Basic basic) {
        super(basic);
        timeStamp = new Date().getTime();
    }

    public long getStamp() {
        return timeStamp;
    }
}

class SerialNumbered extends Decorator {
    private static long counter = 1;
    private final long serialNumber = counter++;

    public SerialNumbered(Basic basic) {
        super(basic);
    }

    private long getSerialNumber() {
        return serialNumber;
    }
}

 class Decoration {
    public static void main(String... args) {
        TimeStamped t = new TimeStamped(new Basic());
        TimeStamped t2 = new TimeStamped(new SerialNumbered(new Basic()));

        SerialNumbered t3 = new SerialNumbered(new Basic());
        SerialNumbered t4 = new SerialNumbered(new TimeStamped(new Basic()));
    }
}