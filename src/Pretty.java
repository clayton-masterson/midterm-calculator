/**
 * Applies formatting for aligning text in the program. The goal is for program
 * text to be right-aligned on the left side, with user text left-aligned on
 * the right side.
 * 
 * @author Clayton Masterson
 * @since 2021-12-06
 */
public class Pretty {
	
	static int leftSpacer = 60;
	static int rightSpacer = leftSpacer + 2;
	
	/**
	 * This method pads out text so that it's right-aligned.
	 * @param input	String. The string to be padded out.
	 * @return		String. The padded string.
	 */
	public static String leftSpacer(String input) {
		return String.format("%" + Integer.toString(leftSpacer) + "s", input);
	}
	
	/**
	 * This method pads out text so it'll line up with user text.
	 * @param input	String. The string to be padded out.
	 * @return		String. The padded string.
	 */
	public static String rightSpacer(String input) {
		return String.format("%" + Integer.toString(rightSpacer) + "s", input);
	}

}
