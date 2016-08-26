package clase06;

public class FechaL
{
	private int d, m, a;

	public FechaL(int dia, int mes, int año) {
		// if !verificar(dia, mes, año)
		//    ERROR.

		d = dia;
		m = mes;
		a = año;
	}

	public void avanzarDias(int numDias) {
	}

	public void avanzarMes(int numMeses) {
	}

	@Override
	public String toString() {
		return d + "/" + m + "/" + a;
	}

}
