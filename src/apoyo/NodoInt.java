package apoyo;

class NodoInt
{
	int val;
	NodoInt sig;

	NodoInt(int elem) {
		val = elem;
	}

	NodoInt(int elem, NodoInt nodo) {
		val = elem;
		sig = nodo;
	}
}
