package clase04;

import java.util.ArrayList;

public class PilaAL implements PilaInt
{
	private ArrayList<Integer> elems;

	public PilaAL() {
		elems = new ArrayList<>();
	}

	public void apilar(int x) {
		elems.add(x);
	}

	public boolean vacia() {
		return elems.isEmpty();
	}

	public Integer tope() {
		if (vacia())
			return null;
		return elems.get(elems.size() - 1);
	}

	public Integer desapilar() {
		if (vacia())
			return null;
		return elems.remove(elems.size() - 1);
	}
}
