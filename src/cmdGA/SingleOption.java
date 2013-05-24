/*
 *  You may not change or alter any portion of this comment or credits
 * of supporting developers from this source code or any supporting source code
 * which is considered copyrighted (c) material of the original comment or credit authors.
 * This program is distributed WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 */

package cmdGA;

import cmdGA.exceptions.IncorrectParameterTypeException;
import cmdGA.parameterType.ParameterType;
/**
 * Represents an Option that accepts just one arguments.
 * 
 * @author Javier Iserte <jiserte@unq.edu.ar>
 *
 */
public class SingleOption extends Option {
	protected Object value=null;

	// CONSTRUCTORS
	/**
	 * Create a new SimpleOption parser.
	 * 
	 * @param parser An instance of Parser that is linked to the option.
	 * @param defaultValue The default value returned 
	 * @param name The string that is used to call this option in the command line.
	 * @param type An instance of ParameterType that represents the type of the value returned.
	 */
	public SingleOption(Parser parser, Object defaultValue, String name, ParameterType type) {
		super(parser, defaultValue, name,type);
	}
	/**
	 * Create a new SimpleOption parser.
	 * 
	 * @param parser An instance of Parser that is linked to the option.
	 * @param defaultValue The default value returned 
	 * @param name The string that is used to call this option in the command line.
	 * @param alias An alias for the name.
	 * @param type An instance of ParameterType that represents the type of the value returned.
	 */
	public SingleOption(Parser parser, Object defaultValue, String name, String alias, ParameterType type) {
		super(parser, defaultValue, name, alias,type);
	}

	// PUBLIC METHODS
	/**
	 * Parses that string that represents the arguments and set its value to the option.
	 * 
	 * @param value Is a string that represents the arguments for an option.
	 */
	@Override
	public void setValue(String value) throws IncorrectParameterTypeException {
		
		if (value.trim().isEmpty()) {
			
			// throw new IncorrectParameterTypeException ("Option " + this.getName() + " needs one argument, but none were found");
			
		    this.value = null;
			
		} else { 
		
		this.value = this.type.parseParameter(value);
		
		}
		
	}
	/**
	 * @return the value of the option
	 */
	public Object getValue(){
		if (this.value==null) return this.defaultValue; 
		return this.value;
	}

}
