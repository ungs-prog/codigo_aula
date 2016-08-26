package clase06;

public class FechaH
{
	private int diasEC;

	public FechaH(int dia, int mes, int año) {
		// if !verificar(dia, mes, año)
		//    ERROR.

		diasEC = calcularDia(dia, mes, año);
	}

	public void sumarDias(int numDias) {
		diasEC += numDias;
	}
}
