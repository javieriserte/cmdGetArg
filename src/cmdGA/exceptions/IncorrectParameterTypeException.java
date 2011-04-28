/*
 *  You may not change or alter any portion of this comment or credits
 * of supporting developers from this source code or any supporting source code
 * which is considered copyrighted (c) material of the original comment or credit authors.
 * This program is distributed WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 */

package cmdGA.exceptions;
/**
 * Exception to advice that a parameter in a command line is incorrect.
 * @author Javier Iserte <jiserte@unq.edu.ar>
 *
 */
public class IncorrectParameterTypeException extends Exception {
	private static final long serialVersionUID = 2322926677443101216L;
	/**
	 * Creates a new instance of IncorrectParameterTypeException
	 * @param message that is showed to client.
	 */
	public IncorrectParameterTypeException (String message) {
		super(message);
	}
	
	
}
