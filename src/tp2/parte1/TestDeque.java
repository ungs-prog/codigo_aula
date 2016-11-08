package tp2.parte1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Deque;

import org.junit.Before;
import org.junit.Test;

public class TestDeque
{
	private Deque<String> deque;

	@Before
	public void setUp() {
		deque = new DequeEnlazada<>();
	}

	@Test
	public void testBasico() {
		assertTrue(deque.isEmpty());

		deque.addFirst("b");
		deque.addLast("c");

		deque.addFirst("a");
		deque.addLast("d");

		assertEquals(4, deque.size());
		assertEquals("a", deque.getFirst());
		assertEquals("d", deque.getLast());
	}

	@Test
	public void testBasicoUlt() {
		deque.addLast("a");
		deque.addLast("b");

		assertFalse(deque.isEmpty());

		assertEquals("a", deque.getFirst());
		assertEquals("b", deque.getLast());
	}

	@Test
	public void testBorradoPrim() {
		deque.addFirst("a");
		deque.addLast("b");
		deque.addLast("c");

		assertEquals("a", deque.removeFirst());
		assertEquals("b", deque.removeFirst());
		assertEquals("c", deque.removeFirst());

		assertEquals(0, deque.size());
	}

	@Test
	public void testBorradoUlt() {
		deque.addLast("a");
		deque.addLast("b");
		deque.addLast("c");

		assertEquals("c", deque.removeLast());
		assertEquals("a", deque.removeFirst());
		assertEquals(1, deque.size());

		assertEquals("b", deque.getFirst());
		assertEquals("b", deque.removeLast());
		assertTrue(deque.isEmpty());
	}

	@Test
	public void testBorradoDupl() {
		deque.addLast("a");
		deque.addLast("b");
		deque.addLast("a");

		assertEquals("a", deque.removeFirst());

		assertEquals("b", deque.getFirst());
		assertEquals("a", deque.getLast());

		assertEquals("a", deque.removeLast());
		assertEquals("b", deque.removeFirst());
	}

	@Test
	public void testBorrarElem() {
		deque.addLast("a");
		deque.addLast("b");
		deque.addLast("c");
		deque.addLast("d");
		deque.addLast("b");
		deque.addLast("e");

		assertFalse(deque.removeFirstOccurrence("x"));
		assertFalse(deque.removeLastOccurrence("y"));
		assertEquals(6, deque.size());

		assertTrue(deque.removeLastOccurrence("b"));
		assertTrue(deque.removeFirstOccurrence("e"));
		assertTrue(deque.removeFirstOccurrence("a"));

		assertEquals("b", deque.getFirst());
		assertEquals("d", deque.getLast());
	}

	@Test
	public void testContains() {
		deque.addLast("a");
		deque.addLast("b");
		deque.addLast("c");
		deque.addLast("d");

		assertTrue(deque.contains("a"));
		assertTrue(deque.contains("b"));
		assertTrue(deque.contains("c"));
		assertTrue(deque.contains("d"));
		assertFalse(deque.contains("x"));

		String elems[] = { "d", "b", "a", "c" };

		// Devuelve true si el deque contiene todos los valores en "elems".
		assertTrue(deque.containsAll(Arrays.asList(elems)));

		assertEquals("a", deque.removeFirst());

		// Como se eliminó "a" del deque, ya no se cumple.
		assertFalse(deque.containsAll(Arrays.asList(elems)));

		deque.clear();
		assertTrue(deque.isEmpty());
		assertEquals(0, deque.size());

		// Un deque siempre contiene todos los elementos de una colección vacía.
		assertTrue(deque.containsAll(Arrays.asList(new String[0])));
	}

	@Test
	public void testAddAll() {
		String elems[] = { "x", "y", "z" };
		assertTrue(deque.addAll(Arrays.asList(elems)));

		assertEquals("x", deque.removeFirst());
		assertEquals(2, deque.size());

		assertFalse(deque.addAll(Arrays.asList(new String[0])));
	}

	// TODO: verificar NoSuchElementException.
}
