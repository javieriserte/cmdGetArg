package cmdGA2;

import cmdGA2.exceptions.IncorrectCommandLineException;
import cmdGA2.returnvalues.ReturnValueParser;

public class SingleArgumentOption<V> extends ArgOption<V> {

	///////////////////////
	// Instance Variables
	V value;
	V defaultValue;
	
	//////////////////////////
	// Constructor
	public SingleArgumentOption(CommandLine commandLine, String name, String alias, 
			ReturnValueParser<V> returnValueParser, V defaultValue, 
			Boolean acceptEscapeCodes) {
		
		super(commandLine, name, alias, returnValueParser,acceptEscapeCodes);
		
		this.setDefaultValue (defaultValue);
		
	}
	public SingleArgumentOption(CommandLine commandLine, String name,  
			ReturnValueParser<V> returnValueParser, V defaultValue, 
			Boolean acceptEscapeCodes) {
		
		super(commandLine, name, null, returnValueParser,acceptEscapeCodes);
		
		this.setDefaultValue (defaultValue);
		
	}
	public SingleArgumentOption(CommandLine commandLine, String name, String alias, 
			ReturnValueParser<V> returnValueParser, V defaultValue) {
		
		super(commandLine, name, alias, returnValueParser,false);
		
		this.setDefaultValue (defaultValue);
		
	}	
	public SingleArgumentOption(CommandLine commandLine, String name,  
			ReturnValueParser<V> returnValueParser, V defaultValue) {
		
		super(commandLine, name, null, returnValueParser,false);
		
		this.setDefaultValue (defaultValue);
		
	}
	//////////////////////////
	// Public Interface
	@Override
	public void parse(String token) throws IncorrectCommandLineException {

		try {

			ReturnValueParser<V> retParser = this.getReturnValueParser();
			
			this.setValue(retParser.parse(token));
			
		} catch (Exception e) {
			
			throw new IncorrectCommandLineException("There was an error trying to parse '" + token + "' (" +e.getClass().getSimpleName() + ") : "+ e.getMessage());
			
		}
		
		
	}

	////////////////////////////////
	// Getters And Setter
	public V getDefaultValue() {
		return defaultValue;
		
	}
	
	public void setDefaultValue(V defaultValue) {
		
		this.defaultValue = defaultValue;
		
	}
	
	private void setValue(V value) {
		
		this.value = value;
		
	}
	
	public V getValue() {
		
		if (this.value ==null ) {
			
			return this.getDefaultValue();
			
		} else {
			
			return this.value;
			
		}
		
	}

	
	
}
