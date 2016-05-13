/**
 * An exception that is thrown when the argument trying to be passed is already present within a list.
 * @author Justin Orr
 *
 */
public class IsPresentException extends Exception
{	
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 * @param message
	 */
	public IsPresentException(String message)
	{
		super("IsPresentException: " + message);
	}
}
