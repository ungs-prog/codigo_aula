package clase15;

import java.util.Collection;

public class ABB
{
	// Podría ser una clase con visibilidad "package"
	// si no queremos usar "static class".
	private static class NodoInt
	{
		int val;
		NodoInt izq;
		NodoInt der;

		NodoInt(int v) {
			val = v;
		}
	}

	private NodoInt raiz;

	// Parte 1: inserción, búsqueda.
	//
	// Decisión de diseño:
	//
	//   - los métodos auxiliares comunican al "padre" el
	//     resultado; el resultado se comunica en forma de Nodo.
	//     Ventaja: no hay que hacer excepciones con árbol vacío.

	public void insertar(int x) {
		insertar(raiz, x);
	}

	private NodoInt insertar(NodoInt p, int x) {
		if (p == null)
			return new NodoInt(x);

		if (x < p.val)
			p.izq = insertar(p.izq, x);
		else if (x > p.val)
			p.der = insertar(p.der, x);

		return p;
	}

	public boolean pertenece(int x) {
		return pertenece(raiz, x);
	}

	private boolean pertenece(NodoInt p, int x) {
		if (p == null)
			return false;

		if (x < p.val)
			return pertenece(p.izq, x);
		if (x > p.val)
			return pertenece(p.der, x);

		return (x == p.val);
	}

	public void eliminar(int x) {
		raiz = eliminar(raiz, x);
	}

	private NodoInt eliminar(NodoInt p, int x) {
		if (p == null)
			return null;
		if (x == p.val) {
			if (p.izq == null)
				return p.der;
			if (p.der == null)
				return p.izq;

			int cambio = maxVal(p.izq);
			p.val = cambio;
			p.izq = eliminar(p.izq, cambio);
		}
		else if (x < p.val) {
			p.izq = eliminar(p.izq, x);
		}
		else if (x > p.val) {
			p.der = eliminar(p.der, x);
		}
		return p;
	}

	private int maxVal(NodoInt p) {
		while (p.der != null) {
			p = p.der;
		}
		return p.val;
	}

	// Parte 2: recorridos.
	//
	// Decisiones de diseño:
	//
	//   - Los recorridos toman la lista destino de los nodos.
	//     Así quien los usa puede decidir si usar ArrayList,
	//     LinkedList, etc.
	//
	//     Alternativa: que los métodos públicos devuelvan siempre
	//     un ArrayList (o bien tener métodos sobrecargados que lo
	//     hagan).

	public void preOrden(Collection<Integer> nodos) {
		preOrden(raiz, nodos);
	}

	public void inOrden(Collection<Integer> nodos) {
		inOrden(raiz, nodos);
	}

	private void preOrden(NodoInt p, Collection<Integer> nodos) {
		if (p != null) {
			nodos.add(p.val);
			preOrden(p.izq, nodos);
			preOrden(p.der, nodos);
		}
	}

	private void inOrden(NodoInt p, Collection<Integer> nodos) {
		if (p != null) {
			inOrden(p.izq, nodos);
			nodos.add(p.val);
			inOrden(p.der, nodos);
		}
	}

	// Parte 3: cálculos.
	//
	// Decisiones de diseño:
	//
	//   - la altura de un árbol de un nodo es 1. Según qué literatura,
	//     suele ser 0 o 1.
	//
	//     Elegir 1 resulta en cálculos más sencillos. Las fórmulas son:
	//
	//         nodos en un árbol binario perfecto: N = (2^h) - 1
	//         altura de un árbol completo de N nodos: h = ⌊log₂(N)⌋ + 1

	public int cantNodos() {
		return cantNodos(raiz);
	}

	public int altura() {
		return altura(raiz);
	}

	private int cantNodos(NodoInt p) {
		if (p == null)
			return 0;
		return 1 + cantNodos(p.izq) + cantNodos(p.der);
	}

	private int altura(NodoInt p) {
		if (p == null)
			return 0;

		return 1 + Math.max(altura(p.izq), altura(p.der));
	}

	// toString()

	@Override
	public String toString() {
		return "ABB<" + toString(raiz) + ">";
	}

	private String toString(NodoInt p) {
		if (p == null)
			return "∅";

		String val = String.valueOf(p.val);
		if (esHoja(p))
			return val;  // La hoja se representa a sí misma.

		return "(" + val + " " + toString(p.izq) + " " + toString(p.der) + ")";
	}

	private boolean esHoja(NodoInt p) {
		return (p.izq == null && p.der == null);
	}
}
