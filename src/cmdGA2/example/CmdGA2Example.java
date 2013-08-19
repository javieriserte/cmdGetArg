package cmdGA2.example;

import java.util.ArrayList;
import java.util.List;

import cmdGA.exceptions.IncorrectParameterTypeException;
import cmdGA2.CommandLine;
import cmdGA2.MultipleArgumentOption;
import cmdGA2.NoArgumentOption;
import cmdGA2.OptionsFactory;
import cmdGA2.SingleArgumentOption;
import cmdGA2.exceptions.IncorrectCommandLineException;
import cmdGA2.returnvalues.DoubleValue;
import cmdGA2.returnvalues.IntegerValue;
import cmdGA2.returnvalues.StringValue;

public class CmdGA2Example {

	/**
	 * @param args
	 * @throws IncorrectParameterTypeException 
	 * @throws IncorrectCommandLineException 
	 */
	public static void main(String[] args) {
		
		args = "-n 12 --bool 3,5,2.2,4 -h -l 6 -s firstline\\nsecondline --jay 5,3,2,4,2,1" .split(" ");
		
		//////////////////////////////////
		// Create the parser
		CommandLine cmd = new CommandLine();
		
		///////////////////////////////////
		// Define Command Line Options
		SingleArgumentOption<Integer> a = new SingleArgumentOption<Integer>(cmd, "--number","-n" , new IntegerValue(), 3,false);
		
		SingleArgumentOption<Integer> l = new SingleArgumentOption<Integer>(cmd, "--long","-l" , new IntegerValue(), 3,false);

		SingleArgumentOption<String> s = new SingleArgumentOption<String>(cmd, "--str","-s" , new StringValue(), "one line",true);
		
		List<Double> d = new ArrayList<Double>();
		d.add(2d);
		d.add(5d);
		MultipleArgumentOption<Double> b = new MultipleArgumentOption<Double>(cmd, "--bool", "-b", ',' ,d , new DoubleValue(),false);
		
		MultipleArgumentOption<Integer> j = OptionsFactory.createBasicCommaSeparatedIntegersArgument(cmd, "--jay");
		
		NoArgumentOption h = new NoArgumentOption(cmd, "--help", "-h");
		
		//////////////////////////////
		// Parse The Command Line
		try {
			cmd.read(args);
		} catch (IncorrectCommandLineException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		
		//////////////////////////////
		// Retrieve Values From 
		// Command Line
		System.out.println("--number is present : " + a.isPresent());
		System.out.println("--number value      : " + a.getValue());
		System.out.println("--number default    : " + a.getDefaultValue());

		System.out.println("--bool is present : " + b.isPresent());
		System.out.println("--bool value      : " + b.getValues());
		System.out.println("--bool default    : " + b.getDefaultValues());

		System.out.println("--help is present : " + h.isPresent());
		System.out.println("--help value      : " + h.getValue());
		
		System.out.println("--long is present : " + l.isPresent());
		System.out.println("--long value      : " + l.getValue());
		System.out.println("--long default    : " + l.getDefaultValue());
		
		System.out.println("--str is present : " + s.isPresent());
		System.out.println("--str value      : " + s.getValue());
		System.out.println("--str default    : " + s.getDefaultValue());

		System.out.println("--jay is present : " + j.isPresent());
		System.out.println("--jay value      : " + j.getValues());
		System.out.println("--jay default    : " + j.getDefaultValues());
		
	}

}
