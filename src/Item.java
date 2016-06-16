import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Item implements Priced {
	private String name = "Unknown";
	private double price = 0.0;

	public Item() {
		System.out.println("Constructor Item() called.");
	}

	public Item(String name) {
		this.name = name;
		System.out.println("Constructor Item(String) called.");
	}

	public Item(String name, double price) {
		this.name = name;
		this.price = price;
		System.out.println("Constructor Item(String, double) called.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "name = " + getName() + ", price = " + getPrice();
	}

	public void test() {
		// Uses the Item.toString() method
		Supplier<String> s1 = this::toString;

		// Uses Object.toString() method
		Supplier<String> s2 = Item.super::toString;

		// Uses Item.getPrice() method
		Supplier<Double> s3 = this::getPrice;

		// Uses Priced.getPrice() method
		Supplier<Double> s4 = Priced.super::getPrice;

		// Uses all method references and prints the results
		System.out.println("this::toString: " + s1.get());
		System.out.println("Item.super::toString: " + s2.get());
		System.out.println("this::getPrice: " + s3.get());
		System.out.println("Priced.super::getPrice: " + s4.get());

		Supplier<Item> func1 = Item::new;
		Function<String, Item> func2 = Item::new;
		BiFunction<String, Double, Item> func3 = Item::new;

		System.out.println(func1.get());
		System.out.println(func2.apply("Apple"));
		System.out.println(func3.apply("Apple", 0.75));

		// Uses an array constructor reference
		Function<Integer, int[]> arrayCreator3 = int[]::new;
		int[] empIds3 = arrayCreator3.apply(5); // Creates an int array of five
												// elements

		// Generic method references
		Function<String[], List<String>> asList = Arrays::<String> asList;

		String[] namesArray = { "Jim", "Ken", "Li" };
		List<String> namesList = asList.apply(namesArray);
		for (String name : namesList) {
			System.out.println(name);
		}
	}
}