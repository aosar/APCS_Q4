import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * This class creates an archive of authors and books.
 * @author Justin Orr
 *
 */
public class BookArchive 
{
	private LinkedHashMap<Author, BookList> archive;	
	/**
	 * Creates an archive for the library.
	 */
	public BookArchive()
	{
		archive = new LinkedHashMap<Author, BookList>();
	}
	
	/**
	 * Adds a new entry to the book archive.
	 * @param Author 
	 * @param Book
	 * @throws IsPresentException
	 * @throws IncorrectAuthorException
	 */
	public void addEntry(Author author, Book book) throws IncorrectAuthorException, IsPresentException
	{
		if(!book.getAuthor().equals(author)) //Makes sure that the author has the right book matched up.
			{throw new IncorrectAuthorException("" + author.getName() + " is not the author of this book: " + book.getTitle());}
		if(containsAuthor(author))
		{
			if(archive.get(author).isPresent(book))
			{
				throw new IsPresentException("This author has this book already in the archive.");
			}
			else
			{
				archive.get(author).addBook(book);
				assignBookIDNumber(author,book);
			}	
		}
		else
		{
			archive.put(author, new BookList());
			archive.get(author).addBook(book);
			assignBookIDNumber(author,book);
		}
	}
	
	/**
	 * Removes an author from the list.
	 * @param Author 
	 * @param Book
	 * @throws NotPresentException
	 */
	public void removeEntry(Author author) throws NotPresentException 
	{
		if(containsAuthor(author))
			archive.remove(author);
		else
			throw new NotPresentException("The author: " + author.getName() + " does not exist within the archive.");
	}
	
	/**
	 * Remove a specified book from the author.
	 * @param Author
	 * @param Book
	 * @throws NotPresentException
	 */
	public void removeAuthorBookEntry(Author author, Book book) throws IncorrectAuthorException, NotPresentException
	{
		if(!book.getAuthor().equals(author)) //Makes sure that the author has the right book matched up.
			{throw new IncorrectAuthorException("" + author.getName() + " is not the author of this book: " + book.getTitle());}
		if(containsAuthor(author))
		{
			if(archive.get(author).isPresent(book))
				archive.get(author).removeBook(book);
			else
				throw new NotPresentException("The book: " + book.getTitle() + " is not listed with the author, so cannot remove.");
		}
		else
		{
			throw new NotPresentException("The author: " + author.getName() + " does not exist within the archive.");
		}
	}
	
	/**
	 * Clears the archive from all entries.
	 */
	public void clearArchive()
	{
		archive.clear();
	}
	
	/**
	 * Checks the archive to see if it has the book argument.
	 * @param boolean
	 */
	public boolean containsBook(Book book)
	{
		if(containsAuthor(book.getAuthor()))
		{
			return archive.get(book.getAuthor()).isPresent(book);
		}
		else 
			return false;
	}
	
	/**
	 * Checks the archive to see if it contains the author.
	 * @param author
	 * @return boolean
	 */
	public boolean containsAuthor(Author author)
	{
		Set<Author> setOfKeys = archive.keySet();
		Iterator<Author> it = setOfKeys.iterator();
		while(it.hasNext())
		{
			Author a = it.next();
			if(author.equals(a))
				return true;
		}
		return false;
	}
	
	/**
	 * Returns the archive object.
	 * @return archive
	 */
	public LinkedHashMap<Author, BookList> getArchive()
	{
		return archive;
	}
	
	/**
	 * Returns an arrayList of authors from of the archive.
	 * @return authorList
	 */
	public AuthorList getAuthorList()
	{
		AuthorList authorList = new AuthorList();
		Set<Author> setOfKeys = archive.keySet();
		Iterator<Author> it = setOfKeys.iterator();
		while(it.hasNext())
		{
			Author a = it.next();
			try
			{
				authorList.addAuthor(a);
			}
			catch(IsPresentException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return authorList;
	}
	
	/**
	 * Returns all of the books in the archive in an arrayList.
	 * @return bookList
	 */
	public BookList getBookList()
	{
		BookList bookList = new BookList();
		Set<Author> setOfKeys = archive.keySet();
		Iterator<Author> it = setOfKeys.iterator();
		while(it.hasNext())
		{
			Author a = it.next();
			BookList list = archive.get(a);
			try
			{
				for(int i = 0; i < list.size(); i++)
				{
					bookList.addBook(list.getBook(i));
				}
			}
			catch(IsPresentException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return bookList;
	}
	
	/**
	 * Returns the specified index of an Author in the list
	 * @param author
	 * @return integer
	 */
	public int getAuthorIndex(Author author) 
	{
		AuthorList list = getAuthorList();
		if(containsAuthor(author))
			return list.getAuthorIndex(author);
		else
			return -1;
	}
	
	/**
	 * Returns the specified index of the Book in the list
	 * @param book
	 * @return integer;
	 */
	public int getBookIndex(Book book)
	{
		if(getAuthorIndex(book.getAuthor()) == -1)
			return -1;
		else
		{
			return archive.get(book.getAuthor()).getBookIndex(book);
		}
	}
	
	/**
	 * Returns the specific bookList under a specific author.
	 * @param Author
	 * @return bookList
	 * @throws NotPresentException
	 */
	public BookList getBookList(Author author) throws NotPresentException
	{
		if(containsAuthor(author))
			return archive.get(author);
		else
			throw new NotPresentException("The author " + author.getName() + " does not exist in the archive.");
	}
	
	/**
	 * Creates a new id number for the book.
	 * Format: ### 
	 * --> the first # = author's position in the list.  
	 * --> the last two ## = book position in book list in the archive under the author.
	 */
	private void assignBookIDNumber(Author author, Book book)
	{
		int idNumber = 0;
		idNumber = (getAuthorIndex(author)+1)*100;
		idNumber += archive.get(author).getBookIndex(book);
		try
		{
			archive.get(author).getBook(book.getTitle()).setID(idNumber);
		}
		catch(NotPresentException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Checks to see if the archive is empty.
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		return archive.isEmpty();
	}
	
	/**
	 * Returns the info from on the archive.
	 * @return info
	 */
	public String toString()
	{
		String info = "Number of Author's: " + getAuthorList().size() + "\tNumber of Books: " + getBookList().size();
		return info;
	}
	
	/**
	 * Displays the person information in a GUI.
	 */
	public void display()
	{
		//Execute GUI code.
	}
}
