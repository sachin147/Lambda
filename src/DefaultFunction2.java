import java.util.function.Function;
import java.util.function.Predicate;

public class DefaultFunction2 {
	public static void main(String[] args) {
		// Create two functions
		Function<Long, Long> square = x -> x * x;
		Function<Long, Long> addOne = x -> x + 1;

		// Compose functions from the two functions
		Function<Long, Long> squareAddOne = square.andThen(addOne);
		Function<Long, Long> addOneSquare = square.compose(addOne);

		// Get an identity function
		Function<Long, Long> identity = Function.<Long> identity();

		// Test the functions
		long num = 5L;
		System.out.println("Number : " + num);
		System.out.println("Square and then add one: "
				+ squareAddOne.apply(num));
		System.out.println("Add one and then square: "
				+ addOneSquare.apply(num));
		System.out.println("Identity: " + identity.apply(num));

		// Square the input, add one to the result, and square the result
		Function<Long, Long> chainedFunction = ((Function<Long, Long>) (x -> x
				* x)).andThen(x -> x + 1).andThen(x -> x * x);
		System.out.println(chainedFunction.apply(3L));

		// Create some predicates
		Predicate<Integer> greaterThanTen = x -> x > 10;
		Predicate<Integer> divisibleByThree = x -> x % 3 == 0;
		Predicate<Integer> divisibleByFive = x -> x % 5 == 0;
		Predicate<Integer> equalToTen = Predicate.isEqual(null);

		// Create predicates using NOT, AND, and OR on other predciates
		Predicate<Integer> lessThanOrEqualToTen = greaterThanTen.negate();
		Predicate<Integer> divisibleByThreeAndFive = divisibleByThree
				.and(divisibleByFive);
		Predicate<Integer> divisibleByThreeOrFive = divisibleByThree
				.or(divisibleByFive);

		// Test the predicates
		int num2 = 10;
		System.out.println("Number: " + num2);
		System.out.println("greaterThanTen: " + greaterThanTen.test(num2));
		System.out.println("divisibleByThree: " + divisibleByThree.test(num2));
		System.out.println("divisibleByFive: " + divisibleByFive.test(num2));
		System.out.println("lessThanOrEqualToTen: "
				+ lessThanOrEqualToTen.test(num2));
		System.out.println("divisibleByThreeAndFive: "
				+ divisibleByThreeAndFive.test(num2));
		System.out.println("divisibleByThreeOrFive: "
				+ divisibleByThreeOrFive.test(num2));
		System.out.println("equalsToTen: " + equalToTen.test(num2));
	}
}
