package ud7JavaBasics;

	import java.util.*;

	public class CorrecciónEjGrupal {

		 public static void main(String[] args) {
		        Map<String, Integer> estudiantesTechTalent = new HashMap<>();
		        estudiantesTechTalent.put("Laia", 23);
		        estudiantesTechTalent.put("Aurora", 30);
		        estudiantesTechTalent.put("Alexandre", 28);
		        estudiantesTechTalent.put("Jose", 26);
		        estudiantesTechTalent.put("Santos", 24);
		        estudiantesTechTalent.put("Manel", 26);
		        estudiantesTechTalent.put("Alejandro", 19);
		        estudiantesTechTalent.put("Isabel", 18);
		        estudiantesTechTalent.put("Toni", 23);
		        estudiantesTechTalent.put("Diego", 22);
		        estudiantesTechTalent.put("Sebas", 29);
		        estudiantesTechTalent.put("Abdel", 20);
		        estudiantesTechTalent.put("Joel", 22);
		        estudiantesTechTalent.put("Jessica", 26);
		        estudiantesTechTalent.put("Ana Maria", 29);

		        // Crear grupos aleatorios por edades
		        List<List<Map.Entry<String, Integer>>> gruposAleatoriosPorEdades = distribuirAleatoriamentePorEdades(estudiantesTechTalent);

		        // Imprimir y mostrar grupos ordenados alfabéticamente
		        System.out.println("Grupos aleatorios por edades (orden alfabético):");
		        imprimirGrupos(gruposAleatoriosPorEdades);

		        // Crear grupos aleatorios alfabéticamente
		        List<List<Map.Entry<String, Integer>>> gruposAleatoriosPorNombre = distribuirAleatoriamentePorNombre(estudiantesTechTalent);

		        // Imprimir y mostrar grupos ordenados alfabéticamente
		        System.out.println("\nGrupos aleatorios por nombre (orden alfabético):");
		        imprimirGrupos(gruposAleatoriosPorNombre);
		    }

		    public static List<List<Map.Entry<String, Integer>>> distribuirAleatoriamentePorEdades(Map<String, Integer> estudiantes) {
		        List<Map.Entry<String, Integer>> listaOrdenadaPorEdad = new ArrayList<>(estudiantes.entrySet());

		        // Ordenar la lista por edades
		        Collections.sort(listaOrdenadaPorEdad, Comparator.comparing(Map.Entry::getValue));

		        // Dividir la lista ordenada en 5 grupos aleatorios
		        return crearGruposAleatorios(listaOrdenadaPorEdad);
		    }

		    public static List<List<Map.Entry<String, Integer>>> distribuirAleatoriamentePorNombre(Map<String, Integer> estudiantes) {
		        List<Map.Entry<String, Integer>> listaOrdenadaPorNombre = new ArrayList<>(estudiantes.entrySet());

		        // Ordenar la lista por nombres
		        Collections.sort(listaOrdenadaPorNombre, Comparator.comparing(Map.Entry::getKey));

		        // Dividir la lista ordenada en 5 grupos aleatorios
		        return crearGruposAleatorios(listaOrdenadaPorNombre);
		    }

		    private static List<List<Map.Entry<String, Integer>>> crearGruposAleatorios(List<Map.Entry<String, Integer>> listaOrdenada) {
		        List<List<Map.Entry<String, Integer>>> gruposAleatorios = new ArrayList<>();
		        Random random = new Random();

		        for (int i = 0; i < listaOrdenada.size(); i += 3) {
		            int fin = Math.min(i + 3, listaOrdenada.size());
		            List<Map.Entry<String, Integer>> grupo = new ArrayList<>(listaOrdenada.subList(i, fin));

		            // Mezclar el grupo aleatoriamente
		            Collections.shuffle(grupo);
		            gruposAleatorios.add(grupo);
		        }

		        return gruposAleatorios;
		    }

		    private static void imprimirGrupos(List<List<Map.Entry<String, Integer>>> grupos) {
		        for (int i = 0; i < grupos.size(); i++) {
		            System.out.println("Grupo " + (i + 1) + ":");
		            for (Map.Entry<String, Integer> estudiante : grupos.get(i)) {
		                System.out.println("Nombre: " + estudiante.getKey() + ", Edad: " + estudiante.getValue());
		            }
		            System.out.println();
		        }
		    }
		}