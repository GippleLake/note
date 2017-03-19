package com.gipplelake.thinking_in_java.generics.create_instance.sample3;

/**
 * 模板方法创建泛型实例
 *
 * @author dengqg
 */
abstract class GenericCreate<T> {
    final T ele;

    GenericCreate() {
        ele = create();
    }

    abstract T create();
}

class User {
    static class UserCreator extends GenericCreate<User> {

        User create() {
            return new User();
        }
    }
}


class Test {
    public static void main(String[] args) {
        new User.UserCreator();
    }
}
