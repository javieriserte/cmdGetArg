/*
 *  You may not change or alter any portion of this comment or credits
 * of supporting developers from this source code or any supporting source code
 * which is considered copyrighted (c) material of the original comment or credit authors.
 * This program is distributed WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 */

package cmdGA.parameterType;

import cmdGA.exceptions.IncorrectParameterTypeException;
/**
 * This class represents a Type for a an argument in a command line.
 * This class is abstract and must be subclassified to concrete classes. 
 * At the moment, there are subclasses for: Int, Double, Float, Integer and Strings types. But can be easy extended to other types. 
 * For example a FileParameter can be easily done, creating a file from a string containing a path for that file. 
 * 
 *
 * @author Javier Iserte <jiserte@unq.edu.ar>
 *
 */
public abstract class ParameterType {

	
	// PUBLIC METHODS
	/**
	 * This methods is called to parse a String containing an argument into an object.
	 * The class of the object return depends on the specific subclass of ParameterType.
	 * This methods implements a "template method" pattern. Calling to 'parse' method of subclasses. 
	 * 
	 */
	public Object parseParameter(String parameter) throws IncorrectParameterTypeException {
		
		try {
			
			return this.parse(parameter);
			
		} catch (Exception e) {
			
			throw new IncorrectParameterTypeException("Parameter: \"" + parameter + "\" can not be parsed" );
			
		}
		
	}
	
	// PROTECTED METHODS	
	/**
	 * Every subclass of ParameterType must have a parse method. This method must create the object that is returned from an String.
	 */
	protected abstract Object parse(String parameter) ;
	
}
