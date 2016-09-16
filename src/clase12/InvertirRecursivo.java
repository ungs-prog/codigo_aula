package clase12;

//
// Versiones RECURSIVAS.
//
public class InvertirRecursivo
{
	public static void invertirCola(ColaInt cola) {
		if (!cola.vacia()) {
			int elem = cola.desencolar();
			invertirCola(cola);
			cola.encolar(elem);
		}
	}

	//
	// Versión sin función auxiliar: “new” en el caso base.
	//
	public static ColaInt pilaInversa(PilaInt pila) {
		if (pila.vacia())
			return new ColaInt();

		int elem = pila.desapilar();
		ColaInt cola = pilaInversa(pila);
		pila.apilar(elem);
		cola.encolar(elem);

		return cola;
	}

	//
	// Versión con función auxiliar: “new” antes de la priemera
	// llamada recursiva.
	//
	public static ColaInt pilaInversa2(PilaInt pila) {
		ColaInt cola_nueva = new ColaInt();
		pilaInversa2_rec(pila, cola_nueva);
		return cola_nueva;
	}

	private static void pilaInversa2_rec(PilaInt pila, ColaInt cola) {
		if (!pila.vacia()) {
			int elem = pila.desapilar();
			pilaInversa2_rec(pila, cola);
			pila.apilar(elem);
			cola.encolar(elem);
		}
	}
}
