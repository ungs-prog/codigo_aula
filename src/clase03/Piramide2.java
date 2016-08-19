package clase03;

import java.util.ArrayList;
import java.util.List;

public class Piramide2
{
	private List<Nivel> niveles;

	public Piramide2(int numNiveles) {
		niveles = new ArrayList<>();

		// Inicializar todos los niveles (vacíos).
		for (int i = 0; i < numNiveles; i++) {
			niveles.add(new Nivel(i));
		}
	}

	public boolean agregar(int elem) {
		for (Nivel n : niveles) {
			if (n.agregar(elem))
				return true;
		}
		return false;

		// for (int i=0; i < niveles.size(); i++)
		//	if (niveles.get(i).agregar(elem))
		//		return true;

	}

	public Integer obtener(int nivel, int pos) {
		// Faltaría verificar errores (ver Piramide3.java).
		return niveles.get(nivel).obtener(pos);
	}
}
