package com.UD21.Calculadora.T21_Ej1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalcDivisasTest {
    private CalcDivisas calculator;

    @BeforeEach
    public void setUp() {
        calculator = new CalcDivisas();
        calculator.initializeStaticRates();
    }

    @Test
    public void testGetExchangeRateUSDToEUR() {
        double rate = calculator.getExchangeRate("USD", "EUR");
        assertEquals(0.85, rate, 0.001);
    }

    @Test
    public void testGetExchangeRateEURToUSD() {
        double rate = calculator.getExchangeRate("EUR", "USD");
        assertEquals(1.18, rate, 0.001);
    }

    @Test
    public void testGetExchangeRateGBPToEUR() {
        double rate = calculator.getExchangeRate("GBP", "EUR");
        assertEquals(1.14, rate, 0.001);
    }

    @Test
    public void testConvertCurrency() {
        try {
			calculator.convertCurrency();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertEquals("85.00 EUR", calculator.display.getText());
    }
    @Test
    public void testInvalidAmountInput() {
        calculator.currentInput.append("invalid");
        assertThrows(NumberFormatException.class, () -> {
            calculator.convertCurrency();
        });
        assertEquals("Error: Entrada no válida", calculator.display.getText());
    }
}
