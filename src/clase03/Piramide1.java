package clase03;

import java.util.ArrayList;
import java.util.List;

public class Piramide1
{
	private int numNiv;  // Número de niveles.
	private int limElem; // Número máximo de elementos (capacidad).
	private List<Integer> elems;

	public Piramide1(int numNiveles) {
		numNiv = numNiveles;
		limElem = gauss(numNiv);
		elems = new ArrayList<>();
	}

	public boolean agregar(int x) {
		if (elems.size() >= limElem) {
			return false;
		}
		return elems.add(x);
	}

	public Integer obtener(int nivel, int pos) {
		int i = idx(nivel, pos);

		if (i >= 0 && i < elems.size())
			return elems.get(i);
		else
			return null;
	}

	private int idx(int nivel, int pos) {
		if (nivel >= numNiv || pos > nivel) {
			return -1;
		}
		return gauss(nivel) + pos;
	}

	private int gauss(int n) {
		return n * (n + 1) / 2;
	}
}
