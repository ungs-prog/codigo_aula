package clase07;

public class PilaEnlazada<T>
{
	private Nodo<T> tope;

	public void apilar(T elem) {
		tope = new Nodo<>(elem, tope);
	}

	public boolean vacia() {
		return tope == null;
	}

	public T tope() {
		if (tope == null)
			return null;

		return tope.val;
	}

	public T desapilar() {
		T v = null;

		if (tope != null) {
			v = tope.val;
			tope = tope.sig;
		}

		return v;
	}
}
