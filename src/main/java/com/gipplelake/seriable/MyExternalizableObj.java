package com.gipplelake.seriable;

import java.io.*;

/**
 * @author dengqg
 *         Externalizable 继承Serializable ，所有序列化操作都得自己实现
 */
public class MyExternalizableObj implements Externalizable {

    private Integer id;
    private String name;
    private String lastName;

    public final static MyExternalizableObj instance = new MyExternalizableObj(1, "13");

    //反序列化需要调用默认构造方法
    public MyExternalizableObj() {
        System.out.println("none-arg constructor");
    }

    public MyExternalizableObj(Integer id, String name) {
        this.id = id;
        this.name = name;
        lastName = "lala";
    }

    //所有字段的序列化都必须显示指定
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(name);
        out.writeObject(lastName);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        name = String.valueOf(in.readObject());
        lastName = String.valueOf(in.readObject());
    }

    private Object readResolve() throws ObjectStreamException {
        return instance;
    }

    @Override
    public String toString() {
        return "MyExternalizableObj{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

class MyExternalizableObjTest {
    public static void main(String[] args) throws Exception {
        File file = new File("MyExternalizableObj.out");

        System.out.println("start serialize ....");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        MyExternalizableObj obj = MyExternalizableObj.instance;
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();

        System.out.println("start deserialize ....");
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        Object o = inputStream.readObject();

        System.out.println(o);
        System.out.println((o).equals(obj));
    }
}
