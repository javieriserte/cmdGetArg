package cmdGA.parameterType;

import java.io.File;

/**
 * This Class represents a File parameter in a command line created from an existing filepath.
 * 
 * @author Javier Iserte <jiserte@unq.edu.ar>
 *
 */

public class InFileParameter extends ParameterType {

	protected static ParameterType singleton = new InFileParameter();
		/**
		 * No instance variables are used, so there is no need of more than one instance.
		 * A 'singleton' pattern is implemented. 

		 * @return the only one instance InFileParameter
		 */	
		public static InFileParameter getParameter() {
			return (InFileParameter) singleton;
		}
		/**
		 * Parse method
		 * 
		 * Creates a File from <code>parameter</code> and returns it.
		 * Accepts quoted or double quoted text and spaces. 
		 * 
		 * @return A File
		 */
		protected Object parse(String parameter) {
			String st = parameter.trim();
			
			st = st.replaceAll("\"", "");
			st = st.replaceAll("\'", "");
			
			File file = new File(st);
			if (file.exists()) {
				return (Object) file;
			} else {
				return null;
			}
		}
		


}

