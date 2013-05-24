/*
 *  You may not change or alter any portion of this comment or credits
 * of supporting developers from this source code or any supporting source code
 * which is considered copyrighted (c) material of the original comment or credit authors.
 * This program is distributed WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 */

package cmdGA.example;

import cmdGA.MultipleOption;
import cmdGA.NoOption;
import cmdGA.Parser;
import cmdGA.SingleOption;
import cmdGA.exceptions.IncorrectParameterTypeException;
import cmdGA.parameterType.*;

import java.util.ArrayList;
import java.util.List;
/**
 * Examples of use of cmdGA package.
 *   
 * @author Javier Iserte <jiserte@unq.edu.ar>
 * 
 * 
 */
public class Example {
	
	public static void main(String[] arg) {

		example_1();
		
		example_2();
		
	}

	private static void example_1() {
		String[] arg;
		arg = "--greetings hi -float 0.34 -int 2 -val 1, 2, 3, 4, 5 --string \"this is a string\" --opt -bool true --va2 1".split(" ");
		// arg contains a command line like array. 23/01
		
		// STEP ONE:
		// Create a Parser.
		Parser parser = new Parser();
		
		// STEP TWO:
		// DEFINE THE POSSIBLE OPTIONS ACCEPTED IN THE COMMAND LINE. (TAKE CARE OF AVOID AMBIGUITY) 
		SingleOption greeting = new SingleOption(parser, "hello", "--greetings", StringParameter.getParameter());
			// Option 'greeting' requires just one string argument. The parameter name is '--greeting'. The default value is 'hello'. Had not alias. 
		SingleOption sfloat = new SingleOption(parser, 1, "-float", FloatParameter.getParameter());
			// Option 'sfloat' requires just one float argument. The parameter name is '-float'. The default value is 1. Had not alias.
		SingleOption sint = new SingleOption(parser, 2, "-int", IntegerParameter.getParameter());		
		SingleOption sstring = new SingleOption(parser, "asdasd", "--string", StringParameter.getParameter());		
		SingleOption sbool = new SingleOption(parser, false, "-bool", BooleanParameter.getParameter());		
		SingleOption sbool2 = new SingleOption(parser, true, "-book", BooleanParameter.getParameter());
		MultipleOption val = new MultipleOption(parser, 4, "-val", ',', IntegerParameter.getParameter());
			// Option 'val' requires one or more integer arguments. The parameter name is '-val'. The default value is 4. Had not alias.
		MultipleOption val2 = new MultipleOption(parser, 2, "--va2", ',', IntegerParameter.getParameter());
		@SuppressWarnings("deprecation")
		NoOption opt = new NoOption(parser, false, "--opt");
			// Option 'opt' requires no arguments. The parameter name is '--opt'. The default value is false. Had not alias.
		
		// STEP THREE
		// PARSE THE COMMAND LINE
		try {
			parser.parseEx(arg);
		} catch (IncorrectParameterTypeException e) {
			System.out.println("Hubo un error:");
			System.out.println(e.getMessage());
			System.out.println("Ejecuci�n finalizada");
			System.exit(1);
		}
		
		// VERIFY WHICH ARGUMENT IS PRESENT IN THE COMMAND LINE
		System.out.println("Options Present In the command line:");
		System.out.println(greeting.getName() + " is present : " + greeting.isPresent());
		System.out.println(sfloat.getName() + " is present : " + sfloat.isPresent());
		System.out.println(sint.getName() + " is present : " + sint.isPresent());
		System.out.println(sbool.getName() + " is present : " + sbool.isPresent());
		System.out.println(sbool2.getName() + " is present : " + sbool2.isPresent());
		System.out.println(sstring.getName() + " is present : " + sstring.isPresent());
		System.out.println(val.getName() + " is present : " + val.isPresent() + " count: " + val.count());
			// For Multipleoption 'count' method indicates how many arguments are present. 
		System.out.println(val.getName() + " is present : " + val.isPresent() + " count: " + val2.count());
		System.out.println(opt.getName() + " is present : " + opt.isPresent());
		
		
		// PRINT VALUES OF OPTIONS
		System.out.println("\nShowing values of options:");
		// FOR SINPLEOPTION AND NO OPTION, USE 'getValue' METHOD WITHOUT ARGUMENT
		System.out.println("value of saludo is: " + greeting.getValue());
		System.out.println("value of sfloat is: " + sfloat.getValue());
		System.out.println("value of sint is: " + sint.getValue());
		System.out.println("value of sbool is: " + sbool.getValue());
		System.out.println("value of sbool2 is: " + sbool2.getValue());
		System.out.println("value of sstring is: " + sstring.getValue());
		System.out.println("value of opt is: " + opt.getValue());
		
		// FOR MULTIPLEOPTION, USE 'getValue' METHOD WITH AN INDEX ARGUMENT
		for (int x=0;x<val.count();x++) {
			System.out.println("value of val at " + x +": " + val.getValue(x));
		}
		
		for (int x=0;x<val2.count();x++) {
			System.out.println("value of val2 at " + x +": " + val2.getValue(x));
		}
	}
	
	private static void example_2()  {
		
		String[] arg;
		
		arg = "-singleWithValue Hello -singleWithoutValue -multipleWithValue a,b,c,d -multipleWithoutValue".split(" ");

		Parser parser = new Parser();
		
		SingleOption singleWithValueOpt = new SingleOption(parser, "Default", "-singleWithValue", StringParameter.getParameter());
		
		SingleOption singleWithoutValueOpt = new SingleOption(parser, "Default", "-singleWithoutValue", StringParameter.getParameter());
		
		MultipleOption multipleWithValueOpt = new MultipleOption(parser, "Default", "-multipleWithValue",',' ,StringParameter.getParameter());
		
		MultipleOption multipleWithoutValueOpt = new MultipleOption(parser, "Default" , "-multipleWithoutValue",',' ,StringParameter.getParameter());
		
		try {
			parser.parseEx(arg);
		} catch (IncorrectParameterTypeException e) {
			e.printStackTrace();
		}
		
		System.out.println("singleWithValue is present: "+ singleWithValueOpt.isPresent());
		
		System.out.println("singleWithoutValue is present: "+ singleWithoutValueOpt.isPresent());
		
		System.out.println("value of singleWithValue is: "+ singleWithValueOpt.getValue().toString());
		
		System.out.println("value of singleWithoutValue is present: "+ singleWithoutValueOpt.getValue().toString());
		
		System.out.println("multipleWithValue is present: "+ multipleWithValueOpt.isPresent());
		
		System.out.println("multipleWithoutValue is present: "+ multipleWithoutValueOpt.isPresent());
		
		List<Object> l1 = new ArrayList<Object>();
		
		for (Object o : multipleWithValueOpt.getValues()) l1.add(o);
		
		System.out.println("value of multipleWithValue is: " + l1.toString());
		
		List<Object> l2 = new ArrayList<Object>();
		
		for (Object o : multipleWithoutValueOpt.getValues()) l2.add(o);
		
		System.out.println("value of multipleWithoutValue is present: "+ l2.toString());
		
	}
	
}
