package com.gipplelake.thinking_in_java.generics.create_instance.sample2;

/**
 * @author dengqg
 */
class Widget {

    static class Factory implements com.gipplelake.thinking_in_java.generics.create_instance.sample2.Factory<Widget> {

        public Widget create() {
            return new Widget();
        }
    }
}
