package clase11;

public class SumatoriaInt
{
	/**
	 * Sumar los N primeros números naturales, recursivamente.
	 *
	 * (TODO: Aún no verifica que N sea positivo.)
	 */
	public static int sumatoria(int n) {
		if (n == 0)
			return 0;// O bien: if (n == 1)
			         //             return 1;

		return n + sumatoria(n - 1);
	}

	/**
	 * Versión alternativa: sumar de menor a mayor.
	 *
	 * (Es más clara la versión anterior, pero esta idea de “sumar por
	 * la izquierda” será útil para SumatoriaList.)
	 */
	public static int sumatoria_izq(int n) {
		return sumatoria_rec(0, n);
	}

	private static int sumatoria_rec(int desde, int hasta) {
		if (desde > hasta)  // O bien: if (desde == hasta)
			return 0;       //             return desde;
		return desde + sumatoria_rec(desde + 1, hasta);
	}

}
