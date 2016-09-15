package clase12;

public class InvertirIterativo
{
	/**
	 * Invierte una pila. No devuelve nada, la modifica.
	 *
	 * Usa una cola para “darle la vuelta”.
	 */
	public static void invertirPila(PilaInt pila) {
		ColaInt cola_aux = new ColaInt();

		while (!pila.vacia())
			cola_aux.encolar(pila.desapilar());

		while (!cola_aux.vacia())
			pila.apilar(cola_aux.desencolar());
	}

	/**
	 * Invierte una cola. No devuelve nada, la modifica.
	 *
	 * Ver versión recursiva en InvertirRecursivo.java.
	 */
	public static void invertirCola(ColaInt cola) {
		PilaInt pila_aux = new PilaInt();

		while (!cola.vacia())
			pila_aux.apilar(cola.desencolar());

		while (!pila_aux.vacia())
			cola.encolar(pila_aux.desapilar());
	}

	/**
	 * Devuelve una cola, resultado de invertir una pila. La pila queda
	 * en su estado original.
	 */
	public static ColaInt pilaInversa(PilaInt pila) {
		PilaInt pila_aux = new PilaInt();
		ColaInt cola_nueva = new ColaInt();

		while (!pila.vacia())
			pila_aux.apilar(pila.desapilar());

		while (!pila_aux.vacia()) {
			int elem = pila_aux.desapilar();
			pila.apilar(elem);
			cola_nueva.encolar(elem);
		}

		return cola_nueva;
	}
}
