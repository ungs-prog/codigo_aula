package apoyo;

/**
 * Implementación de una pila enlazada.
 */
public class PilaInt
{
	private NodoInt tope;

	public void apilar(int elem) {
		tope = new NodoInt(elem, tope);
	}

	public boolean vacia() {
		return tope == null;
	}

	public Integer tope() {
		if (vacia())
			return null;

		return tope.val;
	}

	public Integer desapilar() {
		if (vacia())
			return null;

		int val = tope.val;
		tope = tope.sig;

		return val;
	}
}
