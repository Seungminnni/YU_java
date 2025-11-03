package com.section03;

import com.javamaster.mypackage.Cat;
import java.util.Objects;

public class Example03 {
    public static void main(String[] args) {
        Cat cat01 = new Cat();
        Cat cat02 = new Cat();
        System.out.println(cat01.toString());
        System.out.println(cat02.toString());
        System.out.println(cat01.equals(cat02));
        cat01 = cat02;
        System.out.println(cat01.equals(cat02));
    }
}