package com.UD21.Calculadora.T21_Ej1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeometriaTest {

    @Test
    public void testAreaCirculo() {
        Geometria geometria = new Geometria();
        double radio = 5;
        double expectedArea = Math.PI * radio * radio;
        assertEquals(expectedArea, geometria.areaCirculo(radio), 0.001);
    }

    @Test
    public void testAreaCuadrado() {
        Geometria geometria = new Geometria();
        double lado = 4;
        double expectedArea = lado * lado;
        assertEquals(expectedArea, geometria.areaCuadrado(lado), 0.001);
    }

    @Test
    public void testAreaRectangulo() {
        Geometria geometria = new Geometria();
        double base = 3;
        double altura = 6;
        double expectedArea = base * altura;
        assertEquals(expectedArea, geometria.areaRectangulo(base, altura), 0.001);
    }

    @Test
    public void testAreaTriangulo() {
        Geometria geometria = new Geometria();
        double base = 4;
        double altura = 7;
        double expectedArea = (base * altura) / 2;
        assertEquals(expectedArea, geometria.areaTriangulo(base, altura), 0.001);
    }
}
