package clase02;

public class Piramide
{
	// TODO: Decidir cómo representar el TAD internamente.

	// 1: private int[] elems;
	// 2: private List<Integer> elems;
	// 3: private int[][] elems;
	// 4: crear un TAD Nivel.

	public Piramide(int numNiveles) {
	}

	/**
	 * Agrega un entero a la pirámide.
	 *
	 * Devuelve falso si la pirámide estaba llena.
	 */
	boolean agregar(int x) {
		return false;
	}

	/**
	 * Elimina el último elemento de la pirámide.
	 *
	 * No hace nada si la pirámide estaba vacía.
	 */
	void quitar() {
	}

	/**
	 * Devuelve el elemento en la posición indicada.
	 *
	 * Los niveles y los índices de cada nivel empiezan en 0.
	 */
	int obtener(int nvl, int idx) throws RuntimeException {
		throw new RuntimeException("mensaje descriptivo");
	}
}
