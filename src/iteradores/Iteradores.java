package iteradores;

import java.util.ArrayList;
import java.util.Iterator;

public class Iteradores
{
	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(10);
		lista.add(20);
		lista.add(30);
		lista.add(40);

		Pila pila = new Pila();
		pila.apilar(11);
		pila.apilar(12);
		pila.apilar(13);
		pila.apilar(14);

		forEach(lista);     // #1
		iterator(lista);    // #2
		miIterator(lista);  // #3
		iterarPila(pila);   // #4
	}

	private static void forEach(ArrayList<Integer> l) {
		System.out.println("forEach:");

		for (int elem : l) {
			System.out.println(elem);
		}
	}

	private static void iterator(ArrayList<Integer> l) {
		System.out.println("iterator:");

		Iterator<Integer> iter = l.iterator();

		while (iter.hasNext()) {
			int elem = iter.next();
			System.out.println(elem);
		}
	}

	private static void miIterator(ArrayList<Integer> l) {
		System.out.println("miIterator:");

		MiIterator iter = new MiIterator(l);

		while (iter.hasNext()) {
			int elem = iter.next();
			System.out.println(elem);
		}
	}

	private static void iterarPila(Pila pila) {
		System.out.println("iterarPila:");

		for (int elem : pila) {
			System.out.println(elem);
		}
	}
}
