package clase07;

import java.util.LinkedList;

public class PilaLL<T>
{
	private LinkedList<T> elems;

	public PilaLL() {
		elems = new LinkedList<>();
	}

	public void apilar(T x) {
		elems.addFirst(x);
	}

	public boolean vacia() {
		return elems.isEmpty();
	}

	public T tope() {
		return elems.peekFirst();
	}

	public T desapilar() {
		return elems.pollFirst();
	}
}
