package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    static class Calculator {

        public int add(int a, int b) {
            return a + b;
        }

        public int subtract(int a, int b) {
            return a - b;
        }

        public int multiply(int a, int b) {
            return a * b;
        }
    }

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        assertThat(calculator.add(2, 3)).isEqualTo(5);
    }

    @Test
    public void testSubtraction() {
        Calculator calculator = new Calculator();
        assertThat(calculator.subtract(5, 3)).isEqualTo(2);
    }

    @Test
    public void testMultiplication() {
        Calculator calculator = new Calculator();
        assertThat(calculator.multiply(2, 3)).isEqualTo(6);
    }
}
