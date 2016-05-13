/**
 * An exception that is thrown when a book and the author does not match.
 * @author Justin Orr
 *
 */
public class IncorrectAuthorException extends Exception
{
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs the exception
	 * @param message
	 */
	public IncorrectAuthorException(String message)
	{
		super("Incorrect Author Exception: " + message);
	}
}
