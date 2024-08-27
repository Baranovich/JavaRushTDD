package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void sumMethodShouldReturnSumOfTwoIntegers() {
        int a = 1;
        int b = 2;
        Calculator calc = new Calculator();

        int sum = calc.sum(1, 2);

        Assertions.assertEquals(a + b, sum);
    }
}