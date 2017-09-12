package tad.sye.logica;

public class MotorSyE
{
	//
	// TADs auxiliares.
	//
	private Dado dado;
	private Tablero tabl;
	
	//
	// Estado del juego;
	//
	private int[] posJug;
	private int jugActual;
	private Turno ultimoTurno; 
	
	public MotorSyE(int numJug, int dim) {
		dado = new Dado(6);
		tabl = new Tablero(dim);
		posJug = new int[numJug];
	}

	public Turno siguienteTurno() {
		int tirada = dado.tirar();
		
		Movimiento mov = tabl.avanzar(posJug[jugActual], dado.tirar());
		ultimoTurno = new Turno(jugActual, tirada, mov);
		
		return ultimoTurno;
	}
	
	public boolean seguir() {
		int jug = ultimoTurno.numJugador();
		Movimiento mov = ultimoTurno.movimiento();
			
		// Actualizar la posición 
		posJug[jug] = mov.destino();
			
		// Actualizar el jugador. 
		jugActual = (jug + 1) % posJug.length;
		
		// El juego sigue si no se llegó a la última casilla.
		return mov.destino() < tabl.maxCasilla();
	}
}
