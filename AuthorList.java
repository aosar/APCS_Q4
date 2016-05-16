import java.util.ArrayList;
/**
 * Creates a list of authors for the library's book archive.
 * @author Justin Orr
 *
 */
public class AuthorList extends List<Author>
{
	
	/**
	 * Constructs an Author List
	 */
	public AuthorList()
	{
		super();
	}
	
	/**
	 * Returns the author by name
	 * @param name
	 */
	public Author getAuthor(String name) throws NotPresentException
	{
		for(Author a: super.getArrayList())
		{
			if(a.getName().compareTo(name)==0)
			{
				return a;
			}
		}
		throw new NotPresentException("No Author Present");
	}
	
	/**
	 * Displays the person information in a GUI.
	 */
	public void display()
	{
		//Execute GUI code.
	}
}
