/**
 * Creates a list of books for the library's book archive.
 * @book Justin Orr
 *
 */
public class BookList extends List<Book>
{	
	/**
	 * Constructs an book List
	 */
	public BookList()
	{
		super();
	}
	
	/**
	 * Returns the book by name
	 * @param name
	 */
	public Book getBook(String name) throws NotPresentException
	{
		for(Book a: super.getArrayList())
		{
			if(a.getTitle().compareTo(name)==0)
			{
				return a;
			}
		}
		throw new NotPresentException("No Book Present");
	}
	
	/**
	 * Displays the person information in a GUI.
	 */
	public void display()
	{
		//Execute GUI code.
	}
}
