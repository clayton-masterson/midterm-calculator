import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Defines the various stages for the program and controls moving between them.
 * 
 * @author Clayton Masterson
 * @since 2021-12-06
 */
public class StageControl implements Usable {
	
	/**
	 * Determines if the input parameter matches the pattern parameter.
	 * @param input		String received from the user
	 * @param pattern	String pattern that defines valid input through regex
	 */
	public boolean isMatch(String input, String pattern) {
		Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(input);
		
		return (input == null)
			? false
			: m.matches();
	}
	
	public boolean isDouble(String input) {
		return isMatch(input, validDouble);
	}
	
	public boolean isOperator(String input) {
		return isMatch(input, validOperator);
	}
	
	public boolean isYes(String input) {
		return isMatch(input, validYes);
	}
	
	public boolean isNo(String input) {
		return isMatch(input, validNo);
	}
	
	public boolean isHelp(String input) {
		return isMatch(input, validHelp);
	}
	
	/**
	 * This allows other input to be used to move to a different stage of
	 * the program. Does not include scanner prompts to the user- is meant
	 * to be used inside runFormula() and prompt will come from the while
	 * loops inside that method.
	 * 
	 * @param sc		Scanner. Passed through to endProgram() method.
	 * @param userInput	String. Input received from the scanner.
	 */
	public void escapeFormula(Scanner sc, String userInput) {
		if (isHelp(userInput)) {
			showHelp();
		} else if (isNo(userInput)) {
			endProgram(sc);
		} else {
			showError();
		}
	}
	
	/**
	 * This method creates a Formula object and takes user input to define its
	 * variables. Each step can accept input to escape the formula to other
	 * stages of the program. At the end it prints the solution.
	 * 
	 * @param sc		Scanner. Passed in from the main method.
	 * @param userInput	String. Input received from the scanner.
	 */
	public void runFormula(Scanner sc, String userInput) {
		
		Formula myFormula = new Formula();
		
		System.out.println(); // Spacer
		
		while (myFormula.getNumA() == null) {
			System.out.print(Pretty.leftSpacer("First Number : "));
			userInput = sc.nextLine();
			if (isDouble(userInput)) {
				myFormula.setNumA(userInput);
			} else {
				escapeFormula(sc, userInput);
			}
		}

		while (myFormula.getOperator() == null) {
			System.out.print(Pretty.leftSpacer("Operator : "));
			userInput = sc.nextLine();
			if (isOperator(userInput)) {
				myFormula.setOperator(userInput);
			} else {
				escapeFormula(sc, userInput);
			}
		}
		
		while (myFormula.getNumB() == null) {
			System.out.print(Pretty.leftSpacer("Second Number : "));
			userInput = sc.nextLine();
			if (isDouble(userInput)) {
				myFormula.setNumB(userInput);
			} else {
				escapeFormula(sc, userInput);
			}
		}
		
		// solution() handles the actual math after we have values from the scanner.
		System.out.println(Pretty.leftSpacer("Solution : ") + myFormula.solution() + "\n");
		
	}
	
	/**
	 * This method shows help text.
	 */
	public void showHelp() {
		System.out.println("\n"
				+ Pretty.leftSpacer("Numbers can be any whole number, decimal, pi, or e.\n")
				+ Pretty.leftSpacer("Operators can be +, -, *, /, %, ^, or rt.\n")
				+ Pretty.leftSpacer("You can type QUIT at any time to end the program.\n"));
	}
	
	/**
	 * This method shows 'goodbye' text, closes the scanner, and
	 * ends the program.
	 * 
	 * @param sc	Scanner. Passed through so it can be clsoed.
	 */
	public void endProgram(Scanner sc) {
		System.out.println("\n"
				+ Pretty.leftSpacer("Sorry to see you go. Bye!\n"));
		sc.close();
		System.exit(0);
	}
	
	/**
	 * This method shows a message when non-valid input is received.
	 */
	public void showError() {
		System.out.println("\n"
				+ Pretty.leftSpacer("Input is not valid. Please try again or enter HELP.\n"));
	}

}