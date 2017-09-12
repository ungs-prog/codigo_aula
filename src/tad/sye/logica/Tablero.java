package tad.sye.logica;

//
// Clase interna al paquete. Nunca la exponemos.
//
class Tablero
{
	private int numCasillas;
	private int[] casillas;
	
	public Tablero(int dim) {
		numCasillas = dim * dim;
		casillas = new int[numCasillas];
		
		// 
		// TODO: Código para generar escaleras/serpientes aleatorias.
		//
	}

	
	public Movimiento avanzar(int posActual, int tirada) {
		Accion acc = Accion.NORMAL;
		int destino = posActual + tirada;
		
		// Asumimos que representamos casillas por un desplazamiento
		// positivo o negativo, según sean escalera o serpiente (y
		// desplazamiento 0 para casillas normales).
		if (casillas[destino] > 0) {
			acc = Accion.ESCALERA;
			destino += casillas[destino];
		}
		else if (casillas[destino] < 0) {
			acc = Accion.SERPIENTE;
			destino += casillas[destino];
		}
		
		return new Movimiento(posActual, destino, acc);
	}
	
	public int maxCasilla() {
		return numCasillas - 1;  // Comienzan en 0.
	}
}
