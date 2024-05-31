package com.UD21.Calculadora.T21_Ej1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.ActionEvent;

class CalcCientificaTest {

    private CalcCientifica calculator;

    @BeforeAll
    static void setupAll() {
        System.out.println("Debería ejecutarse una vez antes de todas las pruebas.");
    }

    @BeforeEach
    void setup() {
        calculator = new CalcCientifica();
        System.out.println("Debería ejecutarse antes de cada prueba.");
    }

    @Test
    void testAdd() {
        assertEquals(5.0, calculator.add(2, 3), "2 + 3 debería ser 5");
    }

    @Test
    void testMultiply() {
        assertEquals(6.0, calculator.multiply(2, 3), "2 * 3 debería ser 6");
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(6, 0);
        });
    }

    @Test
    void testMemoryAdd() {
        calculator.memoryClear();
        calculator.memoryAdd(10.0);
        assertEquals(10.0, calculator.memory);
    }

    @Test
    void testTan() {
        calculator.display.setText("0");
        calculator.actionPerformed(new ActionEvent(calculator.buttons[23], ActionEvent.ACTION_PERFORMED, "tan"));
        assertEquals("0.0", calculator.display.getText());
    }

    @Test
    void testSqrt() {
        calculator.display.setText("4");
        calculator.actionPerformed(new ActionEvent(calculator.buttons[26], ActionEvent.ACTION_PERFORMED, "sqrt"));
        assertEquals("2.0", calculator.display.getText());
    }

    @Test
    void testPi() {
        calculator.actionPerformed(new ActionEvent(calculator.buttons[27], ActionEvent.ACTION_PERFORMED, "π"));
        assertEquals(String.valueOf(Math.PI), calculator.display.getText());
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
