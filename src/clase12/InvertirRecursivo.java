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

	public static ColaInt pilaInversa(PilaInt pila) {
		ColaInt cola_nueva = new ColaInt();
		pilaInversa_rec(pila, cola_nueva);
		return cola_nueva;
	}

	private static void pilaInversa_rec(PilaInt pila, ColaInt cola) {
		if (!pila.vacia()) {
			int elem = pila.desapilar();
			pilaInversa_rec(pila, cola);
			pila.apilar(elem);
			cola.encolar(elem);
		}
	}
}
