package cmdGA2.returnvalues;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamValue extends ReturnValueParser<PrintStream> {

	/**
	 * Parse method
	 * 
	 * Creates a File from <code>parameter</code>, and then creates an PrintStream Object from this File.
	 * Accepts quoted or double quoted text and spaces. 
	 * 
	 * @return A PrintStream or null.
	 */
	@Override
	public PrintStream parse(String token) {

		String st = token.trim();
			
		st = st.replaceAll("\"", "");
		
		st = st.replaceAll("\'", "");
			
		File file = new File(st);
		
		PrintStream ps = null;
		
		try {
			
			ps = new PrintStream(file);
		
		} catch (FileNotFoundException e) {
		
			System.out.println("The was a problem openning the Output File: "+ e.getMessage());
		
		}
				
		return ps;
			
	}

}
