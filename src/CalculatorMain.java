import java.util.Scanner;
/**
 * <h1>Simple text calculator</h1>
 * 
 * Simple calculator. Takes text input and does basic math. User can type HELP
 * at any point to receive instructions on how to use the program, or can type
 * QUIT at any point to end the program.
 * 
 * @author  Clayton Masterson
 * @version 1.0
 * @since	2021-12-06
 */
public class CalculatorMain {

	public static Scanner sc;
	public static String userInput;

	public static void main(String[] args) {
		
		System.out.println("This is a basic calculator that will perform an operation on two numbers.\n");
		System.out.print(Pretty.leftSpacer("Are you ready to begin? (y/n) or HELP : "));

		sc = new Scanner(System.in);
		userInput = sc.nextLine();
		StageControl stage = new StageControl();
		
		/**
		 * This first prompt will kick the program off, allowing the user to
		 * ask for help, start the formula, or end the program. If it receives
		 * input it doesn't understand it'll show a message and re-prompt.
		 */
		while (!userInput.isEmpty()) {
			
			if (stage.isHelp(userInput)) {
				stage.showHelp();
				System.out.print(Pretty.leftSpacer("Ready to begin? (y/n) : "));
				userInput = sc.nextLine();
			} else if (stage.isYes(userInput)) {
				stage.runFormula(sc, userInput);
				System.out.print(Pretty.leftSpacer("Go again? (y/n) : "));
				userInput = sc.nextLine();
			} else if (stage.isNo(userInput)){
				stage.endProgram(sc);
			} else {
				stage.showError();
				System.out.print(Pretty.leftSpacer("Ready to begin? (y/n) : "));
				userInput = sc.nextLine();
			}
			
		}
		

	}

}
