package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(Integer.valueOf(5), calculator.add(2, 3));
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(Integer.valueOf(6), calculator.multiply(2, 3));
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        assertEquals(Integer.valueOf(2), calculator.divide(6, 3));
    }
}

