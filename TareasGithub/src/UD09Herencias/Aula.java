package UD09Herencias;

//Clase Aula
public class Aula {
 private int id;
 private int capacidadMaxima;
 private String asignatura;
 private Profesor profesor;
 private Estudiante[] estudiantes;
 private int numEstudiantes;

 // Constructor
 public Aula(int id, int capacidadMaxima, String asignatura, Profesor profesor) {
     this.setId(id);
     this.capacidadMaxima = capacidadMaxima;
     this.asignatura = asignatura;
     this.profesor = profesor;
     this.estudiantes = new Estudiante[capacidadMaxima];
     this.numEstudiantes = 0;
 }

 //getter y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Estudiante[] getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Estudiante[] estudiantes) {
		this.estudiantes = estudiantes;
	}

	public int getNumEstudiantes() {
		return numEstudiantes;
	}

	public void setNumEstudiantes(int numEstudiantes) {
		this.numEstudiantes = numEstudiantes;
	}

	public void agregarEstudiante(Estudiante estudiante) {
        if (numEstudiantes < capacidadMaxima) {
            estudiantes[numEstudiantes++] = estudiante;
        } else {
            System.out.println("El aula está llena, no se puede agregar más estudiantes.");
        }
    }

    // Método para verificar si se puede dar clase en el aula
    public boolean puedeDarClase() {
        // Verificar disponibilidad del profesor
        if (!profesor.estaDisponible()) {
            return false;
        }

        // Verificar si el profesor da la asignatura correspondiente
        if (!profesor.getMateria().equalsIgnoreCase(asignatura)) {
            return false;
        }

        // Verificar si hay más del 50% de estudiantes
        int numAsistentes = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante != null && !estudiante.haceNovillos()) {
                numAsistentes++;
            }
        }
        return numAsistentes > (capacidadMaxima / 2);
    }

    // Método para contar estudiantes aprobados
    public void contarEstudiantesAprobados() {
        int numAprobadosHombres = 0;
        int numAprobadasMujeres = 0;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante != null && estudiante.getCalificacion() >= 5) {
                if (estudiante.getSexo().equalsIgnoreCase("masculino")) {
                    numAprobadosHombres++;
                } else if (estudiante.getSexo().equalsIgnoreCase("femenino")) {
                    numAprobadasMujeres++;
                }
            }
        }

        System.out.println("Estudiantes aprobados:");
        System.out.println("Hombres: " + numAprobadosHombres);
        System.out.println("Mujeres: " + numAprobadasMujeres);
    }
}
