package cmdGA2.returnvalues;

import java.awt.Font;

public class FontValue extends ReturnValueParser<Font> {

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
	@Override
	public Font parse(String token) {

		String st = token.trim();
			
		st = st.substring(1,st.length()-1);

		String[] ss = st.split(",");
			
		switch(ss.length) {
		
		case 1:
			return new Font(ss[0].trim(),0,10);
		case 2:
			return new Font(ss[0].trim(),Integer.parseInt(ss[1].trim()),10);
		case 3:
			return new Font(ss[0].trim(),Integer.parseInt(ss[1].trim()),Integer.parseInt(ss[2].trim()));
		default:
			return null;
		}
			
	}
	
}
