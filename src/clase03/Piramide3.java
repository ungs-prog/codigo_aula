package clase03;

import java.util.ArrayList;
import java.util.List;

public class Piramide3
{
	private List<Nivel> niveles;
	private int ultimo;  // Nos marca el último Nivel usado.

	public Piramide3(int numNiveles) {
		niveles = new ArrayList<>();

		// Inicializar todos los niveles (vacíos).
		for (int i = 0; i < numNiveles; i++) {
			niveles.add(new Nivel(i));
		}
	}

	public boolean agregar(int elem) {
		if (niveles.get(ultimo).lleno()) {
			ultimo++;
		}
		return niveles.get(ultimo).agregar(elem);
	}

	public Integer obtener(int nivel, int pos) {
		// Manejo de errores con excepciones.
		try {
			return niveles.get(nivel).obtener(pos);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
}
