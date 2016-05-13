import java.util.ArrayList;
/**
 * Creates a list of books for the library's book archive.
 * @book Justin Orr
 *
 */
public class BookList 
{
	private ArrayList<Book> bookList;
	
	/**
	 * Constructs an book List
	 */
	public BookList()
	{
		bookList = new ArrayList<Book>();
	}
	
	/**
	 * Returns the bookList
	 * @return bookList
	 */
	public ArrayList<Book> getBookList()
	{
		return bookList;
	}
	
	/**
	 * Sets the bookList
	 * @param bookList
	 */
	public void setBookList(ArrayList<Book> bookList)
	{
		this.bookList = bookList;
	}
	
	/**
	 * Adds an book to the list.
	 * @param book
	 */
	public void addBook(Book book) throws IsPresentException
	{
		if(!isPresent(book))
			bookList.add(book); 
		else
			throw new IsPresentException("Book already exists.");
	}
	
	/**
	 * Adds an array of books to the list.
	 * @param ArrayList<Book>
	 */
	public void add(ArrayList<Book> bookArray) throws IsPresentException
	{
		for(Book b: bookArray)
		{
			addBook(b);
		}
	}
	
	/**
	 * Returns the book by name
	 * @param name
	 */
	public Book getBook(String name) throws NotPresentException
	{
		for(Book a: bookList)
		{
			if(a.getTitle().compareTo(name)==0)
			{
				return a;
			}
		}
		throw new NotPresentException("No Book Present");
	}
	
	/**
	 * Returns the book based on position.
	 * @param index
	 */
	public Book getBook(int index) throws IndexOutOfBoundsException
	{
		try
		{
			return bookList.get(index);
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	/**
	 * Returns the book's index within the list.
	 * @param book
	 * @return index
	 */
	public int getBookIndex(Book book)
	{
		return bookList.indexOf(book);
	}
	
	/**
	 * Remove's the book from the list
	 * @param book
	 */
	public void removeBook(Book book)  throws NotPresentException
	{
		if(isPresent(book))
			bookList.remove(book);
		else
			throw new NotPresentException("Book not Present for removal.");
	}
	
	/**
	 * Remove's the book from the list.
	 * @param index
	 */
	public void removeBook(int index) throws NotPresentException
	{
		if(bookList.get(index).equals(null) || index > size()-1)
			throw new NotPresentException("Book not Present for removal.");
		else
			bookList.remove(index);			
	}
	
	/**
	 * Returns the size of the bookList
	 * @return size
	 */
	public int size()
	{
		return bookList.size();
	}
	
	/**
	 * Compares two lists of books
	 * @param bookList
	 */
	public boolean equals(BookList bookList)
	{
		if(this.size() != bookList.size())
			return false;
		else
		{
			for(int i = 0; i < bookList.size(); i++)
			{
				if(!bookList.getBook(i).equals(this.getBook(i)))
				{
					return false;
				}
			}
			return true;
		}
	}
	
	/**
	 * Returns whether the list is empty or not.
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		return bookList.isEmpty();
	}
	
	/**
	 * Returns the info from the book list.
	 * @param info
	 */
	public String toString()
	{
		String info = "Book List Size: " + bookList.size();
		return info;
	}
	
	/**
	 * Returns a boolean over whether the book already exist inside the list
	 * @param book
	 * @return boolean 
	 */
	public boolean isPresent(Book book)
	{
		for(Book b: bookList)
		{
			if(b.equals(book))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Prints out the books from the list.
	 */
	public void print()
	{
		System.out.println("Books:");
		for(int i = 0; i < bookList.size(); i++)
		{
			System.out.println(bookList.get(i).toString());
		}
	}
	
	/**
	 * Displays the person information in a GUI.
	 */
	public void display()
	{
		//Execute GUI code.
	}
}
