package clase04;

/**
 * Implementación de ejemplo de una pila enlazada.
 *
 */
public class PilaInt
{
	private Nodo tope;

	public void apilar(int elem) {
		tope = new Nodo(elem, tope);
	}

	public boolean vacia() {
		return tope == null;
	}

	public Integer tope() {
		if (tope == null)
			return null;

		return tope.val;
	}

	public Integer desapilar() {
		Integer v = null;

		if (tope != null) {
			v = tope.val;
			tope = tope.sig;
		}

		return v;
	}
}
