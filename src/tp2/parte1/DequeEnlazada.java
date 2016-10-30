package tp2.parte1;

import java.util.Collection;
import java.util.Deque;
import java.util.NoSuchElementException;

public class DequeEnlazada<T> extends DequeBase<T> implements Deque<T> {
	//
	// Métodos de Deque.
	//

	@Override
	public void addFirst(T e) {
		// ...
	}

	@Override
	public void addLast(T e) {
		// ...
	}

	@Override
	public T getFirst() {
		return null;
	}

	@Override
	public T getLast() {
		return null;
	}

	// Sugerencia: para las cuatro primitivas de borrado, usar una misma función
	// auxiliar:
	//
	//      private T borrarNodo(Nodo<T> nodo);

	@Override
	public T removeFirst() {
		return null;
	}

	@Override
	public T removeLast() {
		return null;
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		return false;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		return false;
	}

	@Override
	public int size() {
		return -1;
	}

	//
	// Métodos de Collection.
	//

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void clear() {
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// ...
		return !c.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		// Ayuda: usar java.util.Objects.equals()
		// para evitar problemas con null.
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}
}
