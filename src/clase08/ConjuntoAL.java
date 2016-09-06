package clase08;

import java.util.ArrayList;

/**
 * Conjunto de enteros implementado sobre ArrayList.
 */
public class ConjuntoAL implements ConjuntoInt
{
	private ArrayList<Integer> elems;

	public ConjuntoAL() {
		elems = new ArrayList<>();
	}

	public boolean agregar(int x) {
		if (pertenece(x))
			return false;

		return elems.add(x);
	}

	public boolean pertenece(int x) {
		return elems.contains(x);
	}

	public boolean quitar(int x) {
		if (!pertenece(x))
			return false;

		return elems.remove(new Integer(x));
	}

	public boolean vacio() {
		return elems.isEmpty();
	}

	public int len() {
		return elems.size();
	}
}
