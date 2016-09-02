package clase04;

public class PilaEnlazada implements PilaInt
{
	private NodoInt tope;

	public void apilar(int elem) {
		tope = new NodoInt(elem, tope);
	}

	public boolean vacia() {
		return tope == null;
	}

	public Integer tope() {
		if (tope == null)
			return null;

		return tope.val;
	}

	public Integer desapilar() {
		Integer v = null;

		if (tope != null) {
			v = tope.val;
			tope = tope.sig;
		}

		return v;
	}
}
