package org.quanye.uniontype.test;

import org.junit.Test;
import org.quanye.exttype.Null;
import org.quanye.uniontype.Union;

import java.util.LinkedList;

public class UnionTypeTest {
    @Test
    public void base() {
        Union strOrInt = new Union(String.class, Integer.class, Null.class);
        // error: don't declare type LinkedList
//        strOrInt.set(new LinkedList<>());
        // error: don't set the value
//        strOrInt.get(String.class);
        // set strOrInt to Integer 32
        strOrInt.set(32);
        // reset strOrInt to Integer 132
        strOrInt.set(132);
        // error : strOrInt now is the Integer-type
//        strOrInt.set("hello");
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
        if (nullableStr.isType(Null.class)) {
            System.out.println("nullableStr is null");
        } else {
            System.out.println("nullableStr: " + nullableStr);
        }
    }
}
