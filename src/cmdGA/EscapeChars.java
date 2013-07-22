package cmdGA;

/**
 * Escape Codes for command line arguments.
 * 
 * @author javier
 *
 */
public class EscapeChars {

	public static String escape(String input){

		input = input.replaceAll("\\\\t", "\t");  // Tab
		
		input = input.replaceAll("\\\\n", "\n");  // New line
		
		input = input.replaceAll("\\\\b", "\b");  // Backspace
		
		input = input.replaceAll("\\\\r", "\r");  // Carriage return
		
		input = input.replaceAll("\\\\f", "\f");  // Formfeed
		
		input = input.replaceAll("\\\\'", "\'");  // Single Quotes
		
		input = input.replaceAll("\\\\\"", "\""); // Double Quotes

		input = input.replaceAll("\\\\", "\\");
		
		return input;
		
	}
	
}
