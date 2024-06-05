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
        assertEquals(0.85, rate, 0.001); }
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
        calculator.currentInput.append("100"); // Simular la entrada del usuario
        try {
            calculator.convertCurrency("USD", "EUR"); // Llamar al método con parámetros para la prueba
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("85.00 EUR", calculator.display.getText());
    }
    @Test
    public void testInvalidAmountInput() {
        calculator.currentInput.append("invalid");
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {
            calculator.convertCurrency();
        });
        assertEquals("Error: Entrada no válida", calculator.display.getText());
        assertEquals("Entrada no válida", exception.getMessage());
    }
}
