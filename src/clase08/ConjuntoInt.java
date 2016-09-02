package clase08;

/**
 * TDA "Conjunto de enteros".
 *
 * El conjunto es no ordenado, y no admite duplicados.
 */
public interface ConjuntoInt
{
	/**
	 * Agrega un elemento al conjunto.
	 *
	 * Devuelve true si el elemento no pertenecía previamente al
	 * conjunto (esto es, se agregó); falso si el elemento ya
	 * pertenecía.
	 */
	public boolean agregar(int x);

	/**
	 * Devuelve true si el elemento pertenece al conjunto.
	 */
	public boolean pertenece(int x);

	/**
	 * Elimina un elemento del conjunto.
	 *
	 * Devuelve true si el elemento pertenecía al conjunto, false en
	 * caso de no pertenecer.
	 */
	public boolean quitar(int x);

	/**
	 * Devuelve true si el conjunto está vacío.
	 */
	public boolean vacio();

	/**
	 * Devuelve el número de elementos en el conjunto.
	 */
	public int len();
}
