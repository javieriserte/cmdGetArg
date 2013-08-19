package cmdGA2;

import java.util.ArrayList;
import java.util.List;

import cmdGA2.exceptions.IncorrectCommandLineException;
import cmdGA2.returnvalues.ReturnValueParser;

public class MultipleArgumentOption<V> extends ArgOption<V> {

	/////////////////////////////////////
	// Instance Variables
	protected List<V>     defaultValues;
	protected char       separatingChar;  
	protected List<V>     values=null;

	
	/////////////////////////////////////
	// Constructors
	public MultipleArgumentOption(CommandLine commandLine, String name, String alias, 
			char separatingChar, List<V> defaultValues, ReturnValueParser<V> returnValueParser, 
			Boolean acceptEscapeCodes) {
		
		super(commandLine, name, alias, returnValueParser, acceptEscapeCodes);
		
		this.defaultValues = defaultValues;
		
		this.separatingChar = separatingChar;
		
	}
	
	public MultipleArgumentOption(CommandLine commandLine, String name, 
			char separatingChar, List<V> defaultValues, ReturnValueParser<V> returnValueParser, 
			Boolean acceptEscapeCodes) {
		
		super(commandLine, name, null, returnValueParser, acceptEscapeCodes);
		
		this.defaultValues = defaultValues;
		
		this.separatingChar = separatingChar;
		
	}
	
	public MultipleArgumentOption(CommandLine commandLine, String name, String alias, 
			char separatingChar, List<V> defaultValues, ReturnValueParser<V> returnValueParser) {
		
		super(commandLine, name, alias, returnValueParser, false);
		
		this.defaultValues = defaultValues;
		
		this.separatingChar = separatingChar;
		
	}
	
	public MultipleArgumentOption(CommandLine commandLine, String name, 
			char separatingChar, List<V> defaultValues, ReturnValueParser<V> returnValueParser) {
		
		super(commandLine, name, null, returnValueParser, false);
		
		this.defaultValues = defaultValues;
		
		this.separatingChar = separatingChar;
		
	}
	
	/////////////////////////////////////
	// Public Interface
	/**
	 * Parses an option with many arguments.
	 * 
	 */
	@Override
	public void parse(String tokens) throws IncorrectCommandLineException {
		
		try {
			
			if (tokens.trim().isEmpty()) { 
				
				this.values = new ArrayList<V>();
					
			} else {
				
				String[] token = tokens.split(((Character)separatingChar).toString());
					// Separate the arguments into individual tokens with the separating char.
				
				List<V> arguments = new ArrayList<V>();
				
				ReturnValueParser<V> retParser = this.getReturnValueParser();
				
				for (String string : token) {
					
					arguments.add(retParser.parse(string));
						// parse every token
					
				} 
				
				this.values = arguments;
				
			}
			
		} catch (Exception e) {
			
			throw new IncorrectCommandLineException("There was an error trying to parse '" + tokens + "' (" +e.getClass().getSimpleName() + ") : "+ e.getMessage());
			
		}
		
	}
	
	/**
	 * Returns the values for the option.
	 * @return
	 */
	public List<V> getValues() {
		
		if  (this.values == null) {
			// If null, then the option was not present in the command line.
			// Therefore, the default values list is returned.
			
			return this.getDefaultValues();			
			
		} else {
			
			return this.values;
			
		}
		
	}
	
	/**
	 * Returns the default Value for the option.
	 * 
	 * @return
	 */
	public List<V> getDefaultValues() {
		
		if (defaultValues==null)  {
			// If defaultvalues is null,
			// then return an empty list.
			
			return new ArrayList<V>();
			
		} else {
			
			return this.defaultValues;
			
		}
		
	
	}

}
