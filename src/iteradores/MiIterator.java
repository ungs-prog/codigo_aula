package iteradores;

import java.util.ArrayList;

public class MiIterator
{
	private int i;
	private ArrayList<Integer> lis;

	public MiIterator(ArrayList<Integer> lista) {
		i = 0;
		lis = lista;
	}

	public boolean hasNext() {
		return i < lis.size();
	}

	public int next() {
		int tmp = lis.get(i);
		i++;
		return tmp;
	}
}
