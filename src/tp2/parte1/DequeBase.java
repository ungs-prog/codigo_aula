package tp2.parte1;

import java.util.Collection;
import java.util.Iterator;

abstract class DequeBase<T>
{
	//
	// Métodos de Deque a implementar por el alumno
	//

	public abstract void addFirst(T e);
	public abstract void addLast(T e);

	public abstract T getFirst();
	public abstract T getLast();

	public abstract T removeFirst();
	public abstract T removeLast();

	public abstract boolean removeLastOccurrence(Object e);
	public abstract boolean removeFirstOccurrence(Object e);

	//
	// Métodos de Collection a implementar por el alumno.
	//

	public abstract void clear();
	public abstract boolean isEmpty();

	public abstract boolean contains(Object o);
	public abstract boolean containsAll(Collection<?> c);

	public abstract boolean addAll(Collection<? extends T> c);

	/* *********************************************************** */

	//
	// Variantes que no lanzan excepciones (no hace falta modificar).
	//

	public T peekFirst() { return isEmpty() ? null : getFirst();    }
	public T peekLast()  { return isEmpty() ? null : getLast();     }
	public T pollFirst() { return isEmpty() ? null : removeFirst(); }
	public T pollLast()  { return isEmpty() ? null : removeLast();  }

	//
	// Otros alias para los métodos principales (no modificar).
	//

	public void push(T e)     { addFirst(e); }

	public boolean add(T e)   { addLast(e); return true; }
	public boolean offer(T e) { addLast(e); return true; }

	public boolean offerFirst(T e) { addFirst(e); return true; }
	public boolean offerLast(T e)  { addLast(e);  return true; }

	public T poll()   { return pollFirst();   }
	public T pop()    { return removeFirst(); }
	public T remove() { return removeFirst(); }

	public T peek()    { return peekFirst(); }
	public T element() { return getFirst();  }

	public boolean remove(Object o) { return removeFirstOccurrence(o); }

	//
	// Métodos que no se piden.
	//

	public Iterator<T> iterator()             { return null; }
	public Iterator<T> descendingIterator()   { return null; }

	public <E> E[] toArray(E[] arr)           { return null; }
	public Object[] toArray()                 { return toArray(new Object[0]); }

	public boolean retainAll(Collection<?> c) { throw new UnsupportedOperationException(); }
	public boolean removeAll(Collection<?> c) { throw new UnsupportedOperationException(); }
}
