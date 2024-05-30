package com.UD21.Calculadora.T21_Ej1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    Calculadora calc = new Calculadora();

    @Test
    public void testAddition() {
        assertEquals(5.0, calc.add(calc, 2, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(1.0, calc.subtract(3, 2));
    }

    @Test
    public void testMultiplication() {
        assertEquals(6.0, calc.multiply(2, 3));
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, calc.divide(6, 3));
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(6, 0);
        });
    }
}

