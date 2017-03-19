package com.gipplelake.designmode.builder.tow;

/**
 * @author dengqg
 */
public class Person {
    public Person(Builder builder) {
        this.math = builder.getMath();
        this.chinese = builder.getChinese();
        this.english = builder.getEnglish();
    }

    Person() {
    }

    enum Skin {
        WHITE, BLACK, YELLOW
    }

    private float weight;
    private float height;
    private Skin skin;
    private Integer age;

    private int math;
    private int english;
    private int chinese;

    @Override
    public String toString() {
        return math + "" + english + "" + chinese;
    }

     class Builder {
        private int math;
        private int english;
        private int chinese;

        public int getMath() {
            return math;
        }

        public void setMath(int math) {
            this.math = math;
        }

        public int getEnglish() {
            return english;
        }

        public void setEnglish(int english) {
            this.english = english;
        }

        public int getChinese() {
            return chinese;
        }

        public void setChinese(int chinese) {
            this.chinese = chinese;
        }

        Builder score(int m, int e, int c) {
            this.math = m;
            this.english = e;
            this.chinese = c;
            return this;
        }

        Person build() {
            return new Person(this);
        }

    }

}

class Test {
    public static void main(String[] args) {
      /*  Person person = new Person.Builder().score(123, 123, 123).build();
        System.out.println(person);*/
        Person person = new Person();
        person = person.new Builder().score(123, 123, 123).build();
        System.out.println(person);
    }
}


