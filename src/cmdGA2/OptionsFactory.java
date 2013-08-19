package cmdGA2;

import java.io.InputStream;
import java.io.PrintStream;

import cmdGA2.returnvalues.DoubleValue;
import cmdGA2.returnvalues.InputStreamValue;
import cmdGA2.returnvalues.IntegerValue;
import cmdGA2.returnvalues.PrintStreamValue;
import cmdGA2.returnvalues.StringValue;

/**
 * 
 * 
 * 
 * 
 * @author Javier Iserte
 *
 */
public class OptionsFactory {

	public static SingleArgumentOption<InputStream> createBasicInputStreamArgument(CommandLine cmd) {
		
		return new SingleArgumentOption<InputStream>(cmd, "--infile", new InputStreamValue(), System.in);
		
	}
	
	public static SingleArgumentOption<PrintStream> createBasicPrintStreamArgument(CommandLine cmd) {
		
		return new SingleArgumentOption<PrintStream>(cmd, "--outfile", new PrintStreamValue(), System.out);
		
	}

	public static SingleArgumentOption<Integer> createBasicIntegerArgument(CommandLine cmd,String name, Integer defaultValue) {
		
		return new SingleArgumentOption<Integer>(cmd, name, new IntegerValue(), defaultValue);
		
	}

	public static SingleArgumentOption<Double> createBasicDoubleArgument(CommandLine cmd,String name, Double defaultValue) {
		
		return new SingleArgumentOption<Double>(cmd, name, new DoubleValue(), defaultValue);
		
	}
	
	public static SingleArgumentOption<String> createBasicStringArgument(CommandLine cmd,String name, String defaultValue) {
		
		return new SingleArgumentOption<String>(cmd, name, new StringValue(), defaultValue);
		
	}
	
	public static SingleArgumentOption<String> createEscapedStringArgument(CommandLine cmd,String name, String defaultValue) {
		
		return new SingleArgumentOption<String>(cmd, name, new StringValue(), defaultValue,true);
		
	}
	
	public static MultipleArgumentOption<Integer> createBasicCommaSeparatedIntegersArgument(CommandLine cmd,String name) {
		
		return new MultipleArgumentOption<Integer>(cmd, name, ',', null, new IntegerValue());
		
	}

	
}
