/**
 * An exception that is thrown when the argument trying to be passed is not present within a list.
 * @author Justin Orr
 *
 */
public class NotPresentException extends Exception
{	
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 * @param message
	 */
	public NotPresentException(String message)
	{
		super("NotPresentException: " + message);
	}
}
