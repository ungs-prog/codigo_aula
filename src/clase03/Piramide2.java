package clase03;

import java.util.ArrayList;
import java.util.List;

public class Piramide2
{
	private int limNiv;  // Número máximo de niveles.
	private List<Nivel> niveles;

	public Piramide2(int numNiveles) {
		limNiv = numNiveles;
		niveles = new ArrayList<>();
		niveles.add(new Nivel(0));
	}

	public boolean agregar(int x) {
		return ultimo().agregar(x);
	}

	public Integer obtener(int nivel, int pos) {
		try {
			return niveles.get(nivel).obtener(pos);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	private Nivel ultimo() {
		int cant = niveles.size();
		Nivel ult = niveles.get(cant - 1);

		if (ult.lleno() && cant < limNiv) {
			niveles.add(ult = new Nivel(cant + 1));
		}

		return ult;
	}
}
