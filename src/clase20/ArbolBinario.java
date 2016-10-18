package clase20;

public class ArbolBinario
{
	private Nodo raiz;

	/** Comprueba si el árbol es un árbol binario de búsqueda.
	 *
	 * Se asume que el el árbol es un arbol binario válido (no hay
	 * ciclos, etc.).
	 */
	public boolean esABB() {
		return esABB(raiz, null, null);
	}

	/* Función recursiva para esABB. limIzq y limDer son los límites en
	 * los que deben estar contenidos todos los descendientes.
	 *
	 * Usamos Integer en lugar de int para usar null como "sin límite".
	 */
	private boolean esABB(Nodo nodo, Integer limIzq, Integer limDer) {
		if (nodo == null)
			return true;

		if (limIzq != null && nodo.val > limIzq ||
		    limDer != null && nodo.val < limDer) {
			// El nodo actual ya quedó fuera del límite.
			return false;
		}

		return (esABB(nodo.izq, limIzq, nodo.val) &&
		        esABB(nodo.der, nodo.val, limIzq));
	}
}
