package ud7JavaBasics;

import java.util.ArrayList;

public class T07ArrayList {

	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<>();
		lista.add("Elemento 1");
		lista.add("Elemento 2");
		lista.add("Elemento 3");
		lista.add("Elemento 4");
		lista.add("Elemento 5");
		for(Object o:lista) {
			System.out.println(o);
		}
	}

}