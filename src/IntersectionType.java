import java.io.IOException;

public class IntersectionType {
	public static void main(String args[]) throws IOException {
		Sensitive sen = (Sensitive & Adder) (x, y) -> x + y; // OK
	}
}
