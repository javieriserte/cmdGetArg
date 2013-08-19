package cmdGA2.returnvalues;

import java.io.File;


public class OutfileValue extends ReturnValueParser<File> {
	/**
	 * Parse method
	 * 
	 * Creates a File from <code>parameter</code> and returns it.
	 * Accepts quoted or double quoted text and spaces. 
	 * 
	 * @return A File
	 */
	@Override
	public File parse(String token) {

		String st = token.trim();
			
		st = st.replaceAll("\"", "");
			
		st = st.replaceAll("\'", "");
			
		File file = new File(st);
			
		return file;
		
	}

}
