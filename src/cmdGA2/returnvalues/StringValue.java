package cmdGA2.returnvalues;

public class StringValue extends ReturnValueParser<String> {

	/**
	 * Parse method
	 * 
	 * @return A String
	 */
	@Override
	public String parse(String token) {

		return token;
		
	}

}
