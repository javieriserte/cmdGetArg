package cmdGA.parameterType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import cmdGA.parameterType.ParameterType;

/**
 * This Class represents a InputStream parameter in a command line created from an existing file.
 * The usual default value for this parameter type is the standard input.
 * 
 * @author Javier Iserte <jiserte@unq.edu.ar>
 *
 */

public class InputStreamParameter extends ParameterType {

	protected static ParameterType singleton = new InputStreamParameter();
		/**
		 * No instance variables are used, so there is no need of more than one instance.
		 * A 'singleton' pattern is implemented. 

		 * @return the only one instance InputStreamParameter
		 */	
		public static InputStreamParameter getParameter() {
			return (InputStreamParameter) singleton;
		}
		/**
		 * Parse method
		 * 
		 * Creates a File from <code>parameter</code>, checks if it exists and then creates an InputStream Object from this File.
		 * Accepts quoted or double quoted text and spaces. 
		 * 
		 * @return An InputStream or null.
		 */
		protected Object parse(String parameter) {
			String st = parameter.trim();
			
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
			return (Object) is;
		}
}

