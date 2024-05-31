package com.UD21.Calculadora.T21_Ej1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculadorTest {

    private Calculadora calculator;

    @BeforeAll
    static void setupAll() {
        System.out.println("Debería ejecutarse una vez antes de todas las pruebas.");
    }

    @BeforeEach
    void setup() {
        calculator = new Calculadora();
        System.out.println("Debería ejecutarse antes de cada prueba.");
    }

    @Test
    void testAdd() {
        assertEquals(5.0, calculator.add(2, 3), "2 + 3 debería ser 5");
    }

    @Test
    void testSubtract() {
        assertEquals(1.0, calculator.subtract(3, 2), "3 - 2 debería ser 1");
    }

    @Test
    void testMultiply() {
        assertEquals(6.0, calculator.multiply(2, 3), "2 * 3 debería ser 6");
    }

    @Test
    void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3), "6 / 3 debería ser 2");
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(6, 0);
        });
    }

    @AfterEach
    void tearDown() {
        System.out.println("Debería ejecutarse después de cada prueba.");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Debería ejecutarse una vez después de todas las pruebas.");
    }
}
