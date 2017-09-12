package tad.sye.logica;

public class Movimiento
{
	//
	// Métodos públicos (¡solo de consulta!)
	//
	public int origen() { return orig; }
	public int destino() { return dest; }
	public Accion accion() { return accion; }
	
	//
	// Constructor interno al paquete.
	//
	Movimiento(int from, int to, Accion acc) {
		orig = from;
		dest = to;
		accion = acc;
	}

	//
	// Variables de instancia privadas (¡no hay setters!)
	//
	private int orig;
	private int dest;
	private Accion accion;
}
