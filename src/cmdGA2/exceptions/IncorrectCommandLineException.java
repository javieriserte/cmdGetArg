package cmdGA2.exceptions;

public class IncorrectCommandLineException extends Exception {

	private static final long serialVersionUID = -4523878780779375630L;

	public IncorrectCommandLineException() {
		super();
	}

	public IncorrectCommandLineException(String message, Throwable cause) {
		super(message, cause);
	}

	public IncorrectCommandLineException(String message) {
		super(message);
	}

	public IncorrectCommandLineException(Throwable cause) {
		super(cause);
	}
}
