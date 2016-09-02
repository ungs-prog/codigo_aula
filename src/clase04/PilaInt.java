package clase04;

public interface PilaInt
{
	// Apila un entero.
	public void apilar(int x);

	// Devuelve true si la pila está vacía.
	public boolean vacia();

	// Devuelve el tope de la pila, o null
	// si la pila está vacía.
	public Integer tope();

	// Elimina el primer elemento de la pila, y
	// lo devuelve. Devuelve null si la pila está
	// vacía.
	public Integer desapilar();
}
