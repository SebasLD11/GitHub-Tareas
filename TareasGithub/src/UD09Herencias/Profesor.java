package UD09Herencias;

import java.util.Random;

//Clase Profesor implementa IPersona
public class Profesor extends Persona {
 private String materia;

 public Profesor(String nombre, int edad, String sexo, String materia) {
     super(nombre, edad, sexo);
     this.materia = materia;
 }

 // Método para verificar disponibilidad del profesor (20% de no estar disponible)
 public boolean estaDisponible() {
     Random random = new Random();
     return random.nextDouble() > 0.2;
 }

 // Método getter
 public String getMateria() {
     return materia;
 }
}
