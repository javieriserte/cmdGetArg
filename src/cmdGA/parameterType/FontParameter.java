package cmdGA.parameterType;

import java.awt.Font;
import cmdGA.parameterType.ParameterType;

public class FontParameter extends ParameterType {
	/**
	 * This Class represents a Font parameter in a command line.
	 * 
	 * @author Javier Iserte <jiserte@unq.edu.ar>
	 *
	 */
		protected static FontParameter singleton = new FontParameter();
		/**
		 * No instance variables are used, so there is no need of more than one instance.
		 * A 'singleton' pattern is implemented. 

		 * @return the only one instance FontParameter
		 */	
		public static FontParameter getParameter() {
			return (FontParameter) singleton;
		}
		/**
		 * Parse method.
		 * 
		 * <blockquote>
		 * Accepts: "[fontname, fontstyle, size]" or "[fontname, fontstyle]" or "[fontname]".
		 * </blockquote>
		 * <blockquote>
		 * Example: parse("[arial,0,10]").
		 * </blockquote>
		 * The fontstyle is an integer from 0 to 3:<br>
		 * 0 is for Plain Text.<br>
		 * 1 is for Bold Text.<br>
		 * 2 is for Italic Text.<br>
		 * 3 if for Bold+Italics Text.<br>
		 * 
		 * @return A Font or null
		 */
		protected Object parse(String parameter) {
			String st = parameter.trim();
			
			
			st = st.substring(1,st.length()-1);
			String[] ss = st.split(",");
			
			switch(ss.length) {
			case 1:
				return (Object) new Font(ss[0].trim(),0,10);
			case 2:
				return (Object) new Font(ss[0].trim(),Integer.parseInt(ss[1].trim()),10);
			case 3:
				return (Object) new Font(ss[0].trim(),Integer.parseInt(ss[1].trim()),Integer.parseInt(ss[2].trim()));
			default:
				return null;
			}
		}
}
