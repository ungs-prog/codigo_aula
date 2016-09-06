package clase08;

/**
 * Conjunto de enteros implementado sobre nodos enlazados.
 */
public class ConjuntoEnlazado implements ConjuntoInt
{
	private NodoInt prim;
	private int len;

	public boolean pertenece(int x) {
		NodoInt act = prim;

		while (act != null) {
			if (act.val == x)
				return true;
			act = act.sig;
		}
		return false;
	}

	public boolean agregar(int x) {
		if (pertenece(x))
			return false;

		prim = new NodoInt(x, prim);
		len++;
		return true;
	}

	public boolean quitar(int x) {
		NodoInt ant = null;
		NodoInt act = prim;

		// Encontrar el elemento.
		while (act != null && act.val != x) {
			ant = act;
			act = act.sig;
		}
		if (act == null)
			return false;  // No encontrado.
		if (ant == null)
			prim = act.sig;
		else
			ant.sig = act.sig;

		len--;
		return true;
	}

	public boolean vacio() {
		return prim == null;
	}

	public int len() {
		return len;
	}
}
