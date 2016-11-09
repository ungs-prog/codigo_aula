package tp2.parte1;

import java.util.Collection;
import java.util.Deque;
import java.util.NoSuchElementException;

public class DequeEnlazada<T> extends DequeBase<T> implements Deque<T> {
	//
	// Métodos de Deque.
	//

	/**
	 * Añade un elemento en la cabeza del Deque. O(1)
	 */
	@Override
	public void addFirst(T e) {
		// ...
	}

	/**
	 * Añade un elemento en la cola del Deque. O(1)
	 */
	@Override
	public void addLast(T e) {
		// ...
	}

	/**
	 * Devuelve el primer elemento. O(1)
	 *
	 * Si el Deque está vacío, lanza NoSuchElementException.
	 */
	@Override
	public T getFirst() {
		return null;
	}

	/**
	 * Devuelve el último elemento. O(1)
	 *
	 * Si el Deque está vacío, lanza NoSuchElementException.
	 */
	@Override
	public T getLast() {
		return null;
	}

	/**
	 * Elimina el primer elemento, y lo devuelve. O(1)
	 *
	 * Si el Deque está vacío, lanza NoSuchElementException.
	 */
	@Override
	public T removeFirst() {
		return null;
	}

	/**
	 * Elimina el último elemento, y lo devuelve. O(1)
	 *
	 * Si el Deque está vacío, lanza NoSuchElementException.
	 */
	@Override
	public T removeLast() {
		return null;
	}

	// Sugerencia: Para las dos primitivas borrado anteriores y las dos
	// siguientes, usar un único método auxiliar privado:
	//
	//      private T borrarNodo(Nodo<T> nodo);
	//

	/**
	 * Elimina un elemento, si existe. O(n)
	 *
	 * Elimina por la cabeza, esto es: de estar presente más de una vez,
	 * se elimina la primera instancia.
	 *
	 * Si no existe el elemento, devuelve false.
	 *
	 * La comparación se realiza con equals().
	 */
	@Override
	public boolean removeFirstOccurrence(Object o) {
		return false;
	}

	/**
	 * Elimina un elemento, si existe. O(n)
	 *
	 * Elimina por la cola, esto es: de estar presente más de una vez,
	 * se elimina la última instancia.
	 *
	 * Si no existe el elemento, devuelve false.
	 *
	 * La comparación se realiza con equals().
	 */
	@Override
	public boolean removeLastOccurrence(Object o) {
		return false;
	}

	/**
	 * Devuelve el número de elementos en O(1).
	 */
	@Override
	public int size() {
		return -1;
	}

	//
	// Métodos de Collection.
	//

	/**
	 * Devuelve true si el deque está vacío. O(1)
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

	/**
	 * Vacía el deque. O(1)
	 */
	@Override
	public void clear() {
	}

	/**
	 * Añade, al final del deque, todos los elementos de una colección. O(L)
	 * donde L es el tamaño de la colección.
	 */
	@Override
	public boolean addAll(Collection<? extends T> coleccion) {
		// ...
		return !c.isEmpty();
	}

	/**
	 * Devuelve true si existe un elemento en el deque. O(n)
	 */
	@Override
	public boolean contains(Object o) {
		// Ayuda: usar java.util.Objects.equals()
		// para evitar problemas con null.
		return false;
	}

	/**
	 * Devuelve true si todos los elementos de la colección existen en el Deque.
	 *
	 * Incluir en un comentario la complejidad de su solución.
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}
}
