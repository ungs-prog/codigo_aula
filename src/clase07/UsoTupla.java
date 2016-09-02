package clase07;

public class UsoTupla
{
	public static void main(String[] args) {
		Tupla<Integer, Integer> t1 = new Tupla<>(7, 3);

		// Los enteros se pueden sumar.
		System.out.println(t1.fst() + t1.snd());

		Tupla<String, String> t2 =
		    new Tupla<>("hola", "mundo");

		// Las cadenas se pueden concatenar.
		System.out.println(t2.fst() + " " + t2.snd());

		// Los enteros sí se pueden multiplicar, también.
		System.out.println(t1.fst() * t1.snd());

		// XXX No compila porque el operador * no está definido para String.
		// System.out.println(t2.fst() * t2.snd());
	}
}
