package tad.sye;

import tad.sye.logica.*;

public class Main
{
	public static void main(String[] args) {
		//
		// Se podría preguntar por consola el número de jugadores
		// y la dimensión de tablero deseada.
		//
		MotorSyE sye = new MotorSyE(3, 7);  // 3 jug., dim 7 × 7 = 49 celdas.
		
		while (sye.seguir()) {
			Turno t = sye.siguienteTurno();

			System.out.println("Juega el jugador " + t.numJugador());

			// ...
			
			System.out.println("Tira el dado y sale: " + t.tiradaDado());
			
			Movimiento m = t.movimiento();
			
			switch(m.accion()) {
			
			case NORMAL:
				System.out.println(
					"Avanza desde la casilla " + m.origen() +
					" hasta " + m.destino());
				break;
				
			case SERPIENTE:
				System.out.println(
					"Cae en una serpiente y retrocede hasta " + m.destino());
				break;
				
			case ESCALERA:
				System.out.println(
					"Cae en una escalera y avanza hasta " + m.destino());
				break;
				
			}
		}
	}
}