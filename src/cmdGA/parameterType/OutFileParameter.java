package cmdGA.parameterType;

import java.io.File;

import cmdGA.parameterType.ParameterType;
/**
 * This Class represents a File parameter in a command line.
 * 
 * @author Javier Iserte <jiserte@unq.edu.ar>
 *
 */
public class OutFileParameter extends ParameterType {

	protected static ParameterType singleton = new OutFileParameter();
		/**
		 * No instance variables are used, so there is no need of more than one instance.
		 * A 'singleton' pattern is implemented. 

		 * @return the only one instance OutFileParameter
		 */	
		public static OutFileParameter getParameter() {
			return (OutFileParameter) singleton;
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
			return (Object) file;
		}
		


}
