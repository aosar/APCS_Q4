/**
 * An exception that is thrown when there is an invalid date.
 * @author Justin Orr
 *
 */
public class InvalidDateException extends Exception
{
	private static final long serialVersionUID = 1L;

	/**
	 * Creates an exception with a specific error message.
	 * @param message
	 */
	public InvalidDateException(String message)
	{
		super("Invalid Date Exception: " + message);
	}
}
