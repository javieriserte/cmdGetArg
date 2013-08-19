package cmdGA2;

import cmdGA2.exceptions.IncorrectCommandLineException;
import cmdGA2.returnvalues.BooleanValue;

public class NoArgumentOption extends ArgOption<Boolean> {
	
	////////////////////////////////
	// Constructor
	public NoArgumentOption(CommandLine commandLine, String name, String alias) {
		
		super(commandLine, name, alias, new BooleanValue(),false); 
		
	}
	
	public NoArgumentOption(CommandLine commandLine, String name) {
		
		super(commandLine, name, null, new BooleanValue(),false); 
		
	}

	///////////////////////////////////
	// Public Interface
	@Override
	public void parse(String token) throws IncorrectCommandLineException {
		
		if (!token.trim().equals("")) {
		
			throw new IncorrectCommandLineException("Option: '" + this.getName()+  "' expects no arguments, but '" + token +"' was found.");
		
		}
		
	}
	
	//////////////////////////////////
	// Getters And Setters
	public Boolean getValue() {
		
		return this.isPresent();
		
	}
	
}
