package clase07;

/**
 * Tupla genérica.
 */
public class Tupla<T1, T2>
{
	private T1 a;
	private T2 b;

	public Tupla(T1 a, T2 b) {
		this.a = a;
		this.b = b;
	}

	public T1 fst() { return a; }
	public T2 snd() { return b; }

	@Override
	public String toString() {
		return ("Tupla(" + a.toString() + ", "
		                + b.toString() + ")");
	}
}
