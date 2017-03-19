package com.gipplelake.designmode.adapter.tow;

import com.gipplelake.designmode.adapter.one.Source;
import com.gipplelake.designmode.adapter.one.Target;

/**
 * 对象的适配器模型
 *
 * @author dengqg
 */
public class TargetImpl implements Target {
    Source source;

    TargetImpl(Source source) {
        this.source = source;
    }

    public void say() {
        source.say();
        System.out.println("say-----");
    }

    public void run() {
        System.out.println("run------");
    }
}

