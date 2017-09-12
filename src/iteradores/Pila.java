package iteradores;

import java.util.Iterator;

public class Pila implements Iterable<Integer>
{
	private Nodo tope;

	public void apilar(int x) {
		tope = new Nodo(x, tope);
	}

	@Override
	public Iterator<Integer> iterator() {
		return new IteradorPila(tope);
	}

	private static class IteradorPila implements Iterator<Integer>
	{
		private Nodo act;

		IteradorPila(Nodo n) {
			act = n;
		}

		@Override
		public boolean hasNext() {
			return act != null;
		}

		@Override
		public Integer next() {
			int tmp = act.val;
			act = act.sig;
			return tmp;
		}
	}

	private static class Nodo
	{
		int val;
		Nodo sig;

		Nodo(int v, Nodo n) {
			val = v;
			sig = n;
		}
	}

}
