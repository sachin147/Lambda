import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReference {
	public static void main(String args[]) {
		// Using a lambda expression
		Function<Integer, String> func1 = x -> Integer.toBinaryString(x);
		System.out.println(func1.apply(17));

		// Using a method reference
		Function<Integer, String> func2 = Integer::toBinaryString;
		System.out.println(func2.apply(17));

		// Uses a lambda expression
		BiFunction<Integer, Integer, Integer> func3 = (x, y) -> Integer.sum(x,
				y);
		System.out.println(func3.apply(17, 15));

		// Uses a method reference
		BiFunction<Integer, Integer, Integer> func4 = Integer::sum;
		System.out.println(func4.apply(17, 15));

		// Uses Integer.valueOf(int)
		Function<Integer, Integer> func5 = Integer::valueOf;

		// Uses Integer.valueOf(String)
		Function<String, Integer> func6 = Integer::valueOf;

		// Uses Integer.valueOf(String, int)
		BiFunction<String, Integer, Integer> func7 = Integer::valueOf;

		System.out.println(func5.apply(17));
		System.out.println(func6.apply("17"));
		System.out.println(func7.apply("10001", 2));
	}
}
