package apoyo;

/**
 * Implementación de una cola enlazada.
 */
public class ColaInt
{
	private NodoInt prim;
	private NodoInt ultim;

	public void encolar(int elem) {
		NodoInt nodo = new NodoInt(elem);

		if (vacia())
			prim = nodo;
		else
			ultim.sig = nodo;

		ultim = nodo;
	}

	public boolean vacia() {
		return prim == null;
	}

	public Integer primero() {
		if (vacia())
			return null;

		return prim.val;
	}

	public Integer desencolar() {
		if (vacia())
			return null;

		int val = prim.val;
		prim = prim.sig;

		if (prim == null)
			ultim = null;

		return val;
	}
}
