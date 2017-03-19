package com.gipplelake.designmode.prototype;


import com.gipplelake.designmode.builder.one.Person;

import java.io.*;
import java.util.Date;

/**
 * @author dengqg
 */
public class Prototype implements Cloneable, Serializable {
    private Date date = new Date();
    Person person = new Person();

    public Person getPerson() {
        return person;
    }

    public Date getDate() {
        return date;
    }


    protected Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }

    /* 深复制 */
    public Prototype deepClone() throws IOException, ClassNotFoundException {

        /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Prototype) ois.readObject();
    }
}


class Test {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Prototype prototype = new Prototype();
        Prototype cloned = prototype.clone();
        Prototype cloned2 = prototype.deepClone();
        System.out.println(prototype.getDate().equals(cloned.getDate()));//getTime equals
        System.out.println(prototype.getDate().equals(cloned2.getDate()));
        System.out.println(prototype.getPerson().equals(cloned.getPerson()));
        System.out.println(prototype.getPerson().equals(cloned2.getPerson()));//person不是singleton，也没有readResolve方法
    }
}
