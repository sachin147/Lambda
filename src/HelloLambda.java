public class HelloLambda {
	/**
	 * Functional Interface
	 */
	public interface HelloType {
		/**
		 * Function that will be implemented within the lambda
		 * 
		 * @param text
		 */
		void hello(String text);
	}

	public static void main(String[] args) {
		// Create the lambda, passing a parameter named "text" to the
		// hello() method, returning the string. The lambda is assigned
		// to the helloLambda variable.
		HelloType helloLambda = (String text) -> {
			System.out.println("Hello " + text);
		};
		// Invoke the method call
		helloLambda.hello("Lambda");
	}
}
