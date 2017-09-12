package tad.sye.logica;

public class Turno
{
	//
	// Métodos públicos (¡solo de consulta!)
	//
	public int numJugador() { return jugador; }
	public int tiradaDado() { return tirada; }
	public Movimiento movimiento() { return movimiento; }
	
	//
	// Constructor interno al paquete.
	//
	Turno(int jug, int tir, Movimiento mov) {
		jugador = jug;
		tirada = tir;
		movimiento = mov;
	}

	//
	// Variables de instancia privadas (¡no hay setters!)
	//
	private int jugador;
	private int tirada;
	private Movimiento movimiento;
}
