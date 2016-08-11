package clase01;

public class Cortocircuito
{
	/**
	 * Comprueba si un entero es par, imprimiendo una línea de log.
	 */
	static boolean esPar(int x) {
		System.out.print(" " + x);
		return x % 2 == 0;
	}

	/**
	 * Demuestra la evaluación de cortocircuito.
	 *
	 * https://es.wikipedia.org/wiki/Evaluaci%C3%B3n_de_cortocircuito
	 */
	static boolean funcionLadoDer(int[] arreglo) {
		boolean ret = true;

		for (int i = 0; i < arreglo.length; i++) {
			ret = ret && esPar(arreglo[i]);
			//        ^^^^^^^^^^^^^^^^^^^^ <- llamada a función en el lado derecho.
		}
		return ret;
	}

	static boolean funcionLadoIzq(int[] arreglo) {
		boolean ret = true;

		for (int i = 0; i < arreglo.length; i++) {
			ret = esPar(arreglo[i]) && ret;
			//    ^^^^^^^^^^^^^^^^^^^^ <- llamada a función en el lado izquierdo de &&
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] arreglo = { 2, 4, 6, 7, 8, 10 };

		System.out.print("ret = ret && esPar(x) -> comprueba:");
		funcionLadoDer(arreglo);
		System.out.println();

		System.out.print("ret = esPar(x) && ret -> comprueba:");
		funcionLadoIzq(arreglo);
		System.out.println();
	}
}
