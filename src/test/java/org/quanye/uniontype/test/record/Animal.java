package org.quanye.uniontype.test.record;

public class Animal {
    public String name;
    public float weight;

    public Animal(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
