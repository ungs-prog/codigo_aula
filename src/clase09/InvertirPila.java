package clase09;

import java.util.LinkedList;
import java.util.Queue;

import clase04.PilaEnlazada;
import clase04.PilaInt;

public class InvertirPila
{
	/**
	 * Invierte la pila ‘p’. No devuelve nada, la modifica.
	 *
	 * Usa una cola para “darle la vuelta”. Ver versión incorrecta
	 * abajo.
	 */
	public static void invertirPila(PilaInt p) {
		Queue<Integer> cola = new LinkedList<>();  // Se podría usar nuestra ColaInt también.

		while (!p.vacia())
			cola.add(p.desapilar());

		while (!cola.isEmpty())
			p.apilar(cola.remove());
	}

	/*** VERSIÓN INCORRECTA ***/

	public static void invertirPila_INCORRECTA(PilaInt p) {
		PilaInt p2 = new PilaEnlazada();

		while (!p.vacia())
			p2.apilar(p.desapilar());

		// ‘p2’ es la inversa de ‘p’, sí; pero la siguiente
		// asignación NO tiene efecto fuera de la función.
		p = p2;  // XXX no funciona.
	}

	public static void main(String args[]) {
		PilaInt pila = new PilaEnlazada();
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);

		invertirPila_INCORRECTA(pila);
		System.out.println(pila.tope());
	}
}
