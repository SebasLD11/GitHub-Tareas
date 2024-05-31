package com.UD21.Calculadora.T21_Ej1;

import org.junit.Assert;
import org.junit.Test;
import java.awt.event.ActionEvent;

public class CalcBinTest {

    @Test
    public void testBinaryAddition() {
        CalcBinaria calc = new CalcBinaria();
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "1")); // Ingresar el primer dígito binario
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "0")); // Ingresar el segundo dígito binario
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "+")); // Presionar el botón de suma
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "1")); // Ingresar el primer dígito binario del segundo número
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "1")); // Ingresar el segundo dígito binario del segundo número
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "=")); // Realizar la suma
        Assert.assertEquals("101", calc.display.getText()); // Verificar el resultado en binario
    }

    @Test
    public void testBinarySubtraction() {
        CalcBinaria calc = new CalcBinaria();
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "1")); // Ingresar el primer dígito binario
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "0")); // Ingresar el segundo dígito binario
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "-")); // Presionar el botón de resta
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "1")); // Ingresar el primer dígito binario del segundo número
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "1")); // Ingresar el segundo dígito binario del segundo número
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "=")); // Realizar la resta
        Assert.assertEquals("11", calc.display.getText()); // Verificar el resultado en binario
    }

    @Test
    public void testBinaryAND() {
        CalcBinaria calc = new CalcBinaria();
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "101")); // Ingresar el primer número binario
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "AND")); // Presionar el botón de AND
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "110")); // Ingresar el segundo número binario
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "=")); // Realizar la operación AND
        Assert.assertEquals("100", calc.display.getText()); // Verificar el resultado en binario
    }

    @Test
    public void testBinaryOR() {
        CalcBinaria calc = new CalcBinaria();
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "101")); // Ingresar el primer número binario
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "OR")); // Presionar el botón de OR
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "110")); // Ingresar el segundo número binario
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "=")); // Realizar la operación OR
        Assert.assertEquals("111", calc.display.getText()); // Verificar el resultado en binario
    }

    @Test
    public void testBinaryXOR() {
        CalcBinaria calc = new CalcBinaria();
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "101")); // Ingresar el primer número binario
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "XOR")); // Presionar el botón de XOR
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "110")); // Ingresar el segundo número binario
        calc.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "=")); // Realizar la operación XOR
        Assert.assertEquals("011", calc.display.getText()); // Verificar el resultado en binario
    }
}
