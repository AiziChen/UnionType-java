package org.quanye.uniontype.test;

import org.junit.Test;
import org.quanye.exttype.Null;
import org.quanye.uniontype.Option;
import org.quanye.uniontype.Union;
import org.quanye.uniontype.test.record.Animal;

public class UnionTypeTest {
    @Test
    public void base() {
        Union strOrInt = new Union(String.class, Integer.class, Null.class);
        // error: didn't init the value
//        strOrInt.get(String.class);
        // set strOrInt to Integer 32
        strOrInt.set(32);
        // reset strOrInt to Integer 132
        strOrInt.set(132);
        // reset strOrInt type to String type
        strOrInt.set("hello");
        // error: don't specify type LinkedList
//        strOrInt.set(new LinkedList<>());
        if (strOrInt.isType(Integer.class)) {
            System.out.println("number: " + strOrInt.get(Integer.class));
        } else if (strOrInt.isType(String.class)) {
            System.out.println("string: " + strOrInt.get(String.class));
        } else {
            System.out.println("other type");
        }
        System.out.println(strOrInt);
    }

    @Test
    public void nullValueTest() {
        Union nullableStr = new Union(String.class, Null.class);
        nullableStr.set(Null.instance);
        // or
//        Union nullableStr = new Union(Null.instance, String.class, Null.class);
        if (nullableStr.isType(Null.class)) {
            System.out.println("nullableStr is null");
        } else {
            System.out.println("nullableStr: " + nullableStr.get(String.class));
        }
    }

    @Test
    public void optionTypeTest() {
        // Option type just an `Union(Null.class, T.class)` type
        Option maybeAnimal = new Option(Animal.class);
        System.out.println(maybeAnimal.get(Null.class));
        maybeAnimal.set(new Animal("Little Yellow Bird", 2.32f));
        System.out.println(maybeAnimal.get(Animal.class));
    }
}
