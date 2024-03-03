package com.example.demo;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(Integer.valueOf(5), calculator.add(2, 3));
    }

    @Test
    public void testMulti() {
        Calculator calculator = new Calculator();
        assertEquals(Integer.valueOf(6), calculator.multi(2, 3));
    }

    @Test
    public void testDiv() {
        Calculator calculator = new Calculator();
        assertEquals(Integer.valueOf(2), calculator.div(6, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivByZero() {
        Calculator calculator = new Calculator();
        calculator.div(6, 0);
    }
}
