public class StringReverse {

	public interface ReverseType {
		String reverse(String text);
	}

	public static void main(String[] args) {
		ReverseType newText = (testText) -> {
			String tempStr = "";
			for (String part : testText.split(" ")) {
				tempStr = new StringBuilder(part).reverse().toString();
			}
			return tempStr;
		};

		java.util.function.Function<String, String> newText2 = (testText) -> {
			String tempStr = "";
			for (String part : testText.split(" ")) {
				tempStr = new StringBuilder(part).reverse().toString();
			}
			return tempStr;
		};

		String result = newText.reverse("Sachin");
		System.out.println(result);
		System.out.println(newText2.apply("Sachin"));
	}
}
