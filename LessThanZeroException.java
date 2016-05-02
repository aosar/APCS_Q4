/**
 * This exception is thrown when an argument is less than zero. 
 * @author Justin Orr
 *
 */
public class LessThanZeroException extends Exception
{
	private static final long serialVersionUID = 1L;

	/**
	 * Creates an exception with a specific error message.
	 * @param message
	 */
	public LessThanZeroException(String message)
	{
		super("Less Than Zero Exception: " + message);
	}
}
