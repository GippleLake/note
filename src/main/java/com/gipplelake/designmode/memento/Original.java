package com.gipplelake.designmode.memento;

/**
 * @author dengqg
 */
public class Original {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Memento createMemento() {
        return new Memento(value);
    }

    public void restoreMemento(Memento memento) {
        this.value = memento.getValue();
    }
}

class Test {
    public static void main(String[] args) {
        Original original = new Original();
        original.setValue("init value");
        Memento memento = original.createMemento();
        original.setValue("changed value");
        System.out.println(original.getValue());
        original.restoreMemento(memento);
        System.out.println(original.getValue());
    }
}
