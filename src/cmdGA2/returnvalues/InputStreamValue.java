package cmdGA2.returnvalues;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class InputStreamValue extends ReturnValueParser<InputStream> {

	/**
	 * Parse method
	 * 
	 * Creates a File from <code>parameter</code>, checks if it exists and then creates an InputStream Object from this File.
	 * Accepts quoted or double quoted text and spaces. 
	 * 
	 * @return An InputStream or null.
	 */
	@Override
	public InputStream parse(String token) {
		
		String st = token.trim();
		
		st = st.replaceAll("\"", "");
		
		st = st.replaceAll("\'", "");
		
		File file = new File(st);
		
		InputStream is;
		
		try {
			
			is = new FileInputStream(file);
			
		} catch (FileNotFoundException e) {
			
			System.err.println("Especified "+file.getName()+" not found");
			
			is = null;
			
		}
		
		return is;
	}

}
