package cmdGA2;

import cmdGA2.exceptions.IncorrectCommandLineException;
import cmdGA2.returnvalues.ReturnValueParser;

/**
 * <code>ArgOption</code> (and its subclasses) instances represent one option in a command line.
 * Three kind of options are supported. For each one there is a specific subclass of 
 * <code>ArgOption</code>:

 * <menu>
 * 	<li>Without any arguments - NoArgumentOption class</li>
 * 	<li>With a single argument - SingleArgumentOption class</li>
 *  <li>With many arguments of the same type - MultipleArgumentOption class</li>
 * </menu>
 * 
 * Options have an associated Type. When the command line is parsed, one object of that Type is
 * returned for every argument (one object for SingleArgumentOption, a list of objects for MultipleArgumentOption). 
 * NoArgumentOption has a Boolean Type associated. After parsing, 
 * a boolean value is returned according to if this option was present in the command line or not.
 * 
 * 
 * 
 * @author Javier Iserte
 *
 * @param <V> The Option's argument(s)'s type.  
 */
public abstract class ArgOption<V> {
	
	////////////////////////
	// Instance Variables
	protected CommandLine commandLine; // Parser Linked to the option.
	protected boolean present;         // Is true if the option is present in the command line.
	protected String name;             // The string that is used to call this option in the command line. (i.e. "--thisOption")
	protected String alias;            // An alias for the name. (i.e. "-o")
	protected ReturnValueParser<V> returnValueParser; // An object that parses a String into a V object.
	protected Boolean acceptEscapeCodes;
	
	///////////////////////////
	// Constructor
	public ArgOption(CommandLine commandLine, String name, String alias, ReturnValueParser<V> returnValueParser, Boolean acceptEscapeCodes  ) {
		super();
		this.commandLine = commandLine;
		this.name = name;
		this.alias = alias;
		this.returnValueParser = returnValueParser;
		this.acceptEscapeCodes = acceptEscapeCodes;
		this.commandLine.options.add(this);
	}

	//////////////////////////////
	// Public Interface
	
	public void parseInputText(String text) throws IncorrectCommandLineException {
		
		text = this.escapeCodes(text);
		
		this.parse(text);
		
	}
	
	public boolean isPresent(){
		
		return this.present;
		
	}
	
	public void setPresent(boolean b) {

		this.present = b;
		
	}
	
	///////////////////////////////////
	// Protected methods
	
	protected String escapeCodes(String string) {
		
		if (this.acceptEscapeCodes) {
			
			return EscapeChars.escape(string);
			
		} else {
			
			return string;
			
		}
		
	}
	
	////////////////////////////////
	// Getters and Setters
	protected String getName() {
		
		return name;
		
	}

	protected void setName(String name) {
		
		this.name = name;
		
	}

	protected String getAlias() {
		
		return alias;
		
	}

	protected void setAlias(String alias) {
		
		this.alias = alias;
		
	}

	protected ReturnValueParser<V> getReturnValueParser() {
		
		return returnValueParser;
		
	}

	protected void setReturnValueParser(ReturnValueParser<V> returnValueParser) {
		
		this.returnValueParser = returnValueParser;
		
	}
	
	protected abstract void parse (String token) throws IncorrectCommandLineException;


	
}
