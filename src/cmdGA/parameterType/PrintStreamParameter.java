package cmdGA.parameterType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import cmdGA.parameterType.ParameterType;

/**
 * This Class represents a PrintStream parameter in a command line.
 * The usual default value for this parameter type is the standard output.
 * 
 * @author Javier Iserte <jiserte@unq.edu.ar>
 *
 */
public class PrintStreamParameter extends ParameterType {
		protected static ParameterType singleton = new PrintStreamParameter();
		/**
		 * No instance variables are used, so there is no need of more than one instance.
		 * A 'singleton' pattern is implemented. 

		 * @return the only one instance PrintStreamParameter
		 */	
		public static PrintStreamParameter getParameter() {
			return (PrintStreamParameter) singleton;
		}
		/**
		 * Parse method
		 * 
		 * Creates a File from <code>parameter</code>, and then creates an PrintStream Object from this File.
		 * Accepts quoted or double quoted text and spaces. 
		 * 
		 * @return A PrintStream or null.
		 */
		protected Object parse(String parameter) {
			String st = parameter.trim();
			
			st = st.replaceAll("\"", "");
			st = st.replaceAll("\'", "");
			
			File file = new File(st);
			PrintStream ps = null;
			try {
				ps = new PrintStream(file);
			} catch (FileNotFoundException e) {
				System.out.println("The was a problem openning the Output File");
			}
				
			return (Object) ps;
		}
		


}

