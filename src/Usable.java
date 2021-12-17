/**
 * Strings used for regex pattern matching and 
 * 
 * @author Clayton Masterson
 * @since 2021-12-06
 */
public interface Usable {

	final String validHelp = "h|help|hep";
	final String validDouble = "^-?\\d*\\.{0,1}\\d+$|pi|e";
	final String validOperator = "\\+|\\-|\\*|\\/|\\%|\\^|rt";
	final String validYes = "y|yes|yep|okay|start|begin|continue";
	final String validNo = "n|no|nope|stop|q|qqq|quit|exit";

	boolean isMatch(String input, String pattern);
	boolean isDouble(String input);
	boolean isOperator(String input);
	boolean isYes(String input);
	boolean isNo(String input);
	boolean isHelp(String input);
	
}
