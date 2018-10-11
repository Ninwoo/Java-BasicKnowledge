package top.ninwoo.java.serializable;

import java.io.Serializable;

public class Person implements Serializable {
    String name;
    transient int age;
    Cat cat;

    public Person(String name, int age, Cat cat) {
        this.name = name;
        this.age = age;
        this.cat = cat;
    }

    @Override
    public String toString() {
        return name + "'s age is " + age + " and has a cat " + cat.toString();
    }
}
