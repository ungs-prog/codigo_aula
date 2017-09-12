package tad.sye.logica;

class Dado
{
	private int[] valores;
	
	Dado(int numCaras) {
		//
		// Impementamos un dado común, con valores consecutivos
		// de 1 a numCaras.
		//
		valores = new int[numCaras];
		
		for (int i=0; i < numCaras; i++)
			valores[i] = i + 1;
	}
	
	int tirar() {
		// 
		// TODO: Devolver una posicion de this.valores al azar.
		//
		return valores[0];
	}

}
