

package com.example.demo;

public class Calculator {

    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    public Integer multi(Integer a, Integer b) {
        return a * b;
    }

    public Integer div(Integer a, Integer b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return a / b;
    }
}
