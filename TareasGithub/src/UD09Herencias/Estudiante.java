package UD09Herencias;

import java.util.Random;

//Clase Estudiante implementa IPersona
public class Estudiante extends Persona {
 private double calificacion;

 public Estudiante(String nombre, int edad, String sexo, double calificacion) {
     super(nombre, edad, sexo);
     this.calificacion = calificacion;
 }

 public double getCalificacion() {
     return calificacion;
 }

 // Método para simular si el estudiante hace novillos
 public boolean haceNovillos() {
     Random rand = new Random();
     return rand.nextDouble() < 0.5;
 }
}