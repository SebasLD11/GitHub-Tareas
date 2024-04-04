package UD09Herencias;

public class mainEjecutable {
	    public static void main(String[] args) {
	        // Crear profesor y estudiantes
	    	Profesor profesor = new Profesor("Profesor1", 40, "masculino", "matemáticas");
	    	Estudiante estudiante1 = new Estudiante("Estudiante1", 20, "masculino", 7);
	    	Estudiante estudiante2 = new Estudiante("Estudiante2", 21, "femenino", 4);
	    	Estudiante estudiante3 = new Estudiante("Estudiante3", 22, "masculino", 6);

	        // Crear aula
	    	Aula aula = new Aula(1, 20, "matemáticas", profesor);

	        // Agregar estudiantes al aula
	        aula.agregarEstudiante(estudiante1);
	        aula.agregarEstudiante(estudiante2);
	        aula.agregarEstudiante(estudiante3);

	        // Verificar si se puede dar clase
	        if (aula.puedeDarClase()) {
	            System.out.println("Se puede dar clase en el aula.");
	            // Contar estudiantes aprobados
	            aula.contarEstudiantesAprobados();
	        } else {
	            System.out.println("No se puede dar clase en el aula.");
	        }
	    }
	}