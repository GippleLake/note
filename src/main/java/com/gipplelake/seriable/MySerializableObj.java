package com.gipplelake.seriable;

import java.io.*;

/**
 * @author dengqg
 *         <p>
 *         子类可序列化，父类默认是不可序列化的，并且父类必须存在默认构造函数；
 *         父类可序列化，子类默认也是可序列化的
 */
public class MySerializableObj extends MySerializableObjFather implements Serializable {
    private String name;
    private transient Integer id;
    //引用默认不可序列化，需要实现Serializable
    protected MySerializableObjParam param = new MySerializableObjParam();

    public final static MySerializableObj instance = new MySerializableObj("113", 1);

    //反序列化不会调用构造方法
    private MySerializableObj() {
        System.out.println("no-args constructor invoke");
    }

    public MySerializableObj(String name, Integer id) {

        this.name = name;
        this.id = id;
        System.out.println("constructor invoke");
    }

    @Override
    public String toString() {

        return super.toString() + "MySerializableObj{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }


    //提供writeObject和readObject覆盖默认序列化机制,可重新使transient属性序列化（通过反射调用）
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(id);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        id = objectInputStream.readInt();
    }

    //返回的对象直接替换在反序列化过程中创建的对象，而被创建的对象则会被垃圾回收掉
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }


}

class MySerializableObjFather implements Serializable {

    public String fatherName;


    //子类实现序列化。反序列化时父类会调用默认构造方法
    public MySerializableObjFather() {
        System.out.println("father no-args constructor invoke");
        fatherName = "123";
    }

    @Override
    public String toString() {
        return "MySerializableObjFather{" +
                "fatherName='" + fatherName + '\'' +
                '}';
    }
}

class MySerializableObjParam implements Serializable {

    private String name;

    public MySerializableObjParam() {
        System.out.println("param no-args constructor invoke");
    }
}

class MySerializableObjTest {

    public static void main(String[] args) throws Exception {
        File file = new File("MySerializableObj.out");

        System.out.println("start serialize ....");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        MySerializableObj obj = MySerializableObj.instance;
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();

        System.out.println("start deserialize ....");
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        Object o = inputStream.readObject();
        System.out.println(o);
        System.out.println(obj.equals(o));
    }
}