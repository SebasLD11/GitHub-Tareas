package com.UD21.Calculadora.T21_Ej1;

public class GeometriaJunit 
{
    public static void main( String[] args )
    {
	   //Creacion de Objeto Circulo
	   Geometria gm=new Geometria();
	   double areaCirc= gm.areaCirculo(2);
	   gm.setArea(areaCirc);    
	   System.out.println(gm);
    }
}
