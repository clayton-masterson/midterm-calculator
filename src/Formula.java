/**
 * This is the formula itself. Contains the object and methods for converting
 * String input to doubles as well as the method for performing the
 * calculation.
 * 
 * @author Clayton Masterson
 * @since 2021-12-06
 */
public class Formula {
	
	private double numA;
	private double numB;
	private String stringA;
	private String stringB;
	private String operator;
	
	/**
	 * Constructors for Formula
	 */
	public Formula () {};
	public Formula (double numA, String operator, double numB) {
		this.numA = numA;
		this.operator = operator;
		this.numB = numB;
	}
	
	/**
	 * Converts a string into a double, checking first for pi and e.
	 * Will throw exception if it receives incompatible input.
	 * @param input	String. This is the string to parse and convert.
	 * @return		double. This is the double to be output.
	 */
	public double toDouble(String input) {
		
		double dubOut;
		
		if (input.equalsIgnoreCase("pi")) {
			dubOut = Math.PI;
		} else if (input.equalsIgnoreCase("e")) {
			dubOut = Math.E;
		} else {
			try {
				dubOut = Double.parseDouble(input);				
			} catch (NumberFormatException e) {
				throw new NumberFormatException("\n\nI tried to convert a String to a double\nBut I messed up and got into trouble\n");
			}
		}
		
		return dubOut;
	}
	
	/**
	 * This method does the actual math for the Formula object. It switches
	 * through the defined operators and throws an exception if it receives an
	 * operator it doesn't understand.
	 * @return	The solution as a double.
	 */
	public double solution() {
		
		double solution;
		
		switch (this.operator) {
		case "+":
			solution = this.numA + this.numB;
			break;
		case "-":
			solution = this.numA - this.numB;
			break;
		case "*":
			solution = this.numA * this.numB;
			break;
		case "/":
			solution = this.numA / this.numB;
			break;
		case "%":
			solution = this.numA % this.numB;
			break;
		case "^":
			solution = Math.pow(this.numA, this.numB);
			break;
		case "rt":
			solution = Math.pow(this.numA, (1 / this.numB));
			break;
		default:
			throw new RuntimeException(Pretty.leftSpacer("\n\nI didn't understand that operator\nTell me about it and I'll check it later\n"));
		}
		
		return solution;
	}
	
	/**
	 * This method overrides toString() to print out the full formula.
	 */
	@Override
	public String toString() {
		return this.numA + " " + this.operator + " " + this.numB + " = " + this.solution();
	}

	/**
	 * Getters and Setters for the Formula object. The setters for the numbers
	 * convert them into doubles and stores the original string for the getters
	 */
	
	// Get & Set String numA
	public String getNumA() {
		return this.stringA;
	}
	public void setNumA(String input) {
		this.numA = toDouble(input);
		this.stringA = input;
	}

	// Get & Set String numB
	public String getNumB() {
		return this.stringB;
	}
	public void setNumB(String input) {
		this.numB = toDouble(input);
		this.stringB = input;
	}

	// Get & Set String operator
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator.toLowerCase();
	} 

}
