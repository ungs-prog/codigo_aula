package clase03;

import java.util.ArrayList;
import java.util.List;

public class Piramide3 {
	private int limNiv;  // Número máximo de niveles.
	private List<Nivel> niveles;

	public Piramide3(int numNiveles) {
		limNiv = numNiveles;
		niveles = new ArrayList<>();
		for (int i=0;i<limNiv;i++) {
			niveles.add(new Nivel(i));
		}
	}

	public boolean agregar(int x) {
		boolean agregado = false;
		int i = 0;
		while (!agregado && i<limNiv) {
			agregado = niveles.get(i).agregar(x);
			i=i+1;
		}
		return agregado;
	}

	public Integer obtener(int nivel, int pos) {
		try {
			return niveles.get(nivel).obtener(pos);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
}
