package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void sumMethodShouldReturnSumOfTwoIntegers() {
        int a = 1;
        int b = 2;

        Calculator calc = new Calculator();

        int sum = calc.sum(a, b);

        assertEquals(a + b, sum);
        org.assertj.core.api.Assertions.assertThat(sum).isEqualTo(a + b);
    }
}