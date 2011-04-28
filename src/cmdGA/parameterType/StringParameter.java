/*
 *  You may not change or alter any portion of this comment or credits
 * of supporting developers from this source code or any supporting source code
 * which is considered copyrighted (c) material of the original comment or credit authors.
 * This program is distributed WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 */

package cmdGA.parameterType;
/**
 * This Class represents a Boolean parameter in a command line.
 * 
 * @author Javier Iserte <jiserte@unq.edu.ar>
 *
 */
public class StringParameter extends ParameterType {
	protected static ParameterType  singleton = new StringParameter();
	/**
	 * No instance variables are used, so there is no need of more than one instance.
	 * A 'singleton' pattern is implemented. 

	 * @return the only one instance BooleanParameter
	 */	
	public static StringParameter getParameter() {
		return (StringParameter) singleton;
	}
	/**
	 * Parse method
	 * 
	 * @return A String
	 */
	protected Object parse(String parameter) {
		return (Object) parameter.trim();
	}
	


}
