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

		deque.push("a");
		deque.offer("d");

		assertEquals(4, deque.size());
		assertEquals("a", deque.getFirst());
		assertEquals("d", deque.getLast());
	}

	@Test
	public void testBasicoUlt() {
		assertNull(deque.peek());

		assertTrue(deque.add("a"));
		assertTrue(deque.add("b"));

		assertFalse(deque.isEmpty());
		assertEquals("a", deque.peekFirst());
		assertEquals("b", deque.peekLast());
	}

	@Test
	public void testBorradoPrim() {
		assertNull(deque.pollLast());
		assertNull(deque.pollFirst());

		assertTrue(deque.offerFirst("a"));
		assertTrue(deque.offerLast("b"));
		assertTrue(deque.offerLast("c"));

		assertEquals("a", deque.removeFirst());
		assertEquals("b", deque.remove());
		assertEquals("c", deque.pop());

		assertEquals(0, deque.size());
		assertNull(deque.poll());
	}

	@Test
	public void testBorradoUlt() {
		assertNull(deque.peekLast());

		deque.add("a");
		deque.add("b");
		deque.add("c");

		assertEquals("c", deque.removeLast());
		assertEquals("a", deque.pollFirst());
		assertEquals(1, deque.size());

		assertEquals("b", deque.element());
		assertEquals("b", deque.pollLast());
		assertTrue(deque.isEmpty());
	}

	@Test
	public void testBorrarElem() {
		deque.add("a");
		deque.add("b");
		deque.add("c");
		deque.add("d");
		deque.add("b");
		deque.add("e");

		assertFalse(deque.remove("x"));
		assertFalse(deque.removeLastOccurrence("y"));
		assertEquals(6, deque.size());

		assertTrue(deque.removeLastOccurrence("b"));
		assertTrue(deque.removeFirstOccurrence("e"));
		assertTrue(deque.remove("a"));

		assertEquals("b", deque.getFirst());
		assertEquals("d", deque.getLast());
	}

	@Test
	public void testContains() {
		deque.add("a");
		deque.add("b");
		deque.add("c");
		deque.add("d");

		assertTrue(deque.contains("a"));
		assertTrue(deque.contains("b"));
		assertTrue(deque.contains("c"));
		assertTrue(deque.contains("d"));
		assertFalse(deque.contains("x"));

		String elems[] = { "d", "b", "a", "c" };
		assertTrue(deque.containsAll(Arrays.asList(elems)));

		assertEquals("a", deque.pop());
		assertFalse(deque.containsAll(Arrays.asList(elems)));

		deque.clear();
		assertTrue(deque.isEmpty());
		assertEquals(0, deque.size());

		assertTrue(deque.containsAll(Arrays.asList(new String[0])));
	}

	@Test
	public void testAddAll() {
		String elems[] = { "x", "y", "z" };
		assertTrue(deque.addAll(Arrays.asList(elems)));

		assertEquals("x", deque.poll());
		assertEquals(2, deque.size());

		assertFalse(deque.addAll(Arrays.asList(new String[0])));
	}

	// TODO: verificar NoSuchElementException.
}
