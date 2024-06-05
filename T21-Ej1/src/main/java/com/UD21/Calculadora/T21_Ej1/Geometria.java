package com.UD21.Calculadora.T21_Ej1;

public class Geometria {
    private int id;
    private String nom;
	
    public Geometria(int id, String nom) {
        this.setId(id);
        this.setNom(nom);
    }
    public Geometria() {
        this.setId(9);
        this.setNom("Default");   
    }
        // Método para calcular el área de un círculo
        public double areaCirculo(double radio) {
            return Math.PI * radio * radio;
        }

        // Método para calcular el área de un cuadrado
        public double areaCuadrado(double lado) {
            return lado * lado;
        }

        // Método para calcular el área de un rectángulo
        public double areaRectangulo(double base, double altura) {
            return base * altura;
        }

        // Método para calcular el área de un triángulo
        public double areaTriangulo(double base, double altura) {
            return (base * altura) / 2;
        }
		public void setArea(double area) {			
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
    }




