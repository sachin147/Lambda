import java.io.IOException;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class DefaultFunction {
	public static void main(String args[]) throws IOException {
		// Takes an int and returns its square
		Function<Integer, Integer> square1 = x -> x * x;
		IntFunction<Integer> square2 = x -> x * x;
		ToIntFunction<Integer> square3 = x -> x * x;
		UnaryOperator<Integer> square4 = x -> x * x;

		System.out.println(square1.apply(5));
		System.out.println(square2.apply(5));
		System.out.println(square3.applyAsInt(5));
		System.out.println(square4.apply(5));
	}
}
