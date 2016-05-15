import java.util.LinkedHashMap;
import java.util.ArrayList;
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
				sort();
			}	
		}
		else
		{
			archive.put(author, new BookList());
			archive.get(author).addBook(book);
			assignBookIDNumber(author,book);
			sort();
		}
	}
	
	/**
	 * Adds an entry for an author that has a list of books already present.
	 * @param author
	 * @param bookList
	 * @throws IncorrectAuthorException
	 * @throws IsPresentException
	 */
	public void addEntry(Author author, BookList bookList) throws IsPresentException, IncorrectAuthorException
	{
		for(int i = 0; i < bookList.size(); i++)//Checks to make sure the books and author correspond with each other.
		{
			if(!bookList.getBook(i).getAuthor().equals(author))
				throw new IncorrectAuthorException("The book: " + bookList.getBook(i) + " does not match it's author.");
		}
		if(containsAuthor(author))
		{
			for(int i = 0; i < archive.get(author).size(); i++)
			{
				if(archive.get(author).isPresent(bookList.getBook(i)))
				{
					throw new IsPresentException("The book: " + bookList.getBook(i) + " is already present in the list, please remove before entering.");
				}
			}
		}
		else
		{
			archive.put(author, bookList);
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
	 * Returns a list of authors from of the archive.
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
	 * Returns a list of authors in the form of an array list.
	 * @return list
	 */
	public ArrayList<Author> getAuthorArrayList()
	{
		ArrayList<Author> list = getAuthorList().getAuthorList();
		return list;
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
	 * Returns an arrayList of the bookLists.
	 * @return listOfBookLists
	 */
	public ArrayList<BookList> getBookLists()
	{
		Set<Author> setOfKeys = archive.keySet();
		Iterator<Author> it = setOfKeys.iterator();
		ArrayList<BookList> list = new ArrayList<BookList>();
		while(it.hasNext())
		{
			Author a = it.next();
			BookList b = archive.get(a);
			list.add(b);
		}
		return list;
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
	 * Sorts the book archive.
	 */
	public void sort()
	{
		//Creates array lists of all of the entries and their correspondents
		ArrayList<Author> listOfAuthors = getAuthorList().getAuthorList(); //The first returns a list of type AuthorList and the second is an arrayList of Authors.
		ArrayList<BookList> listOfBookLists = getBookLists(); //Creates an array list of book lists so that they correspond with the right author.
		//Sorts the new created arrayLists using bubble sort.
		for(int i = 0; i < listOfAuthors.size(); i++)
		{
			for(int j = 1; j < listOfAuthors.size(); j++)
			{
				if(listOfAuthors.get(j).toString().compareTo(listOfAuthors.get(i).toString()) < 0)
				{
					Author temp = listOfAuthors.get(j);
					BookList temp2 = listOfBookLists.get(j);
					listOfAuthors.set(j, listOfAuthors.get(i));
					listOfBookLists.set(j, listOfBookLists.get(i));
					
					listOfAuthors.set(i, temp);
					listOfBookLists.set(i, temp2);
				}
			}
		}
		
		//Clears the archive and re-adds them in the new order.
		clearArchive();
		for(int i = 0; i < listOfAuthors.size(); i++)
		{
			for(int j = 0; j < listOfBookLists.get(i).size(); j++)
			{
				try{addEntry(listOfAuthors.get(i), listOfBookLists.get(i));}
				catch(IsPresentException | IncorrectAuthorException e){System.out.println(e.getMessage());}
			}
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
