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
 * This Class represents an abstract option and its value.
 * To work correctly an option must be linked to a parser.
 * 
 * An option must had a name, that is the string in the command line to call this option. Also, can have an alias.
 * The type of the parameters must be declared, using a instance of ParameterType. 
 * A default value must be provided.
 * 
 * @author Javier Iserte <jiserte@unq.edu.ar>
 *
 */
public abstract class Option {
	// INSTANCE VARIABLES
	protected Parser parser;          // Parser Linked to the option.
	protected boolean present;        // Is true if the option is present in the command line.
	protected Object defaultValue;    // Is the default value if none is provided.
	protected String name;            // The string that is used to call this option in the command line. (i.e. "--thisOption")
	protected String alias;           // An alias for the name. (i.e. "-o")
	protected ParameterType type;     // The type of the value returned.
	
	// CONSTRUCTOR
	/**
	 * Creates a new instance of Option with alias.
	 *  
	 * @param parser An instance of Parser that is linked to the option.
	 * @param defaultValue The default value returned 
	 * @param name The string that is used to call this option in the command line.
	 * @param alias An alias for the name.
	 * @param type An instance of ParameterType that represents the type of the value returned. 
	 */
	public Option(Parser parser, Object defaultValue, String name, String alias, ParameterType type) {
		super();
		this.parser = parser;
		this.defaultValue = defaultValue;
		this.name = name;
		this.alias = alias;
		this.type = type;
		this.parser.options.add(this);
	}
	
	/**
	 * Creates a new instance of Option with no alias.
	 *  
	 * @param parser An instance of Parser that is linked to the option.
	 * @param defaultValue The default value returned 
	 * @param name The string that is used to call this option in the command line.
	 * @param type An instance of ParameterType that represents the type of the value returned. 
	 */
	public Option(Parser parser, Object defaultValue, String name, ParameterType type) {
		super();
		this.parser = parser;
		this.defaultValue = defaultValue;
		this.name = name;
		this.alias = null;
		this.type = type;
		this.parser.options.add(this);
	}

	// GETTERS & SETTERS
	public boolean isPresent() {
		return present;
	}
	protected void setPresent(boolean present) {
		this.present = present;
	}
	public String getName() {
		return name;
	}
	public String getAlias() {
		return alias;
	}
	
	// PUBLIC METHODS
	/**
	 * Parses the string and set the value to an option.
	 */
	public abstract void setValue(String value) throws IncorrectParameterTypeException;
	

	

	
	

	
	
	
}
