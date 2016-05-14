import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * This class is used to govern the books that are being checked out, 
 * their authors, accesses it's own book archive and etc...
 * @author Justin Orr, Arianna Osar
 *
 */
public class Library 
{
	private BookArchive bookArchive;
	private LibraryFund fund;
	private final double FEE = 20.00;
	private Scanner fileScan;
	
	/**
	 * Creates a library object.
	 * @param fund
	 * @param bookArchive
	 */
	public Library(BookArchive bookArchive, LibraryFund fund)
	{
			this.bookArchive = bookArchive;
			this.fund = fund;
	}
	
	/**
	 * Checks to see if the book is checked out or not.
	 * @param Book
	 * @return boolean
	 * @throws NotPresentException
	 */
	public boolean getCheckedOutStatus(Book book) throws NotPresentException
	{
		if(bookArchive.containsBook(book))
			return book.getCheckedOutStatus();
		else
			throw new NotPresentException("The book: " + book.getTitle() + " does not exist within the archive.");
	}
	
	/**
	 * Checks out the specified book.
	 * @param book
	 * @param checkOutDate
	 * @param returnDate
	 */
	public void checkOutBook(Book book, Date checkOutDate, Date returnDate)
	{
		try
		{
			if(getCheckedOutStatus(book) == true)
			{
				System.out.println("Can't check out this book. It is already checked out.");
			}
			else
			{
				setCheckedOutStatus(book, true);
				setCheckOutDate(book, checkOutDate);
				setReturnDate(book, returnDate);
			}
		}
		catch(NotPresentException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Returns a book to the archive by changing the checked out status to true if the book is within the archive.
	 * @param book
	 * @param checkInDate
	 */
	public void checkInBook(Patron patron, Book book, Date checkInDate) throws NotPresentException
	{
		if(!bookArchive.containsBook(book))
			throw new NotPresentException("The book: " + book.getTitle() + " does not exist in the archive.");
		else
		{
			if(getCheckedOutStatus(book) == true)
			{
				if(book.getReturnDate().toString().compareTo(checkInDate.toString()) < 0)
				{
					charge(patron, checkInDate);
				}
				bookArchive.getArchive().get(book.getAuthor()).getBook(book.getTitle()).setCheckedOutStatus(false); //Sets the status to false for the book.
			}
			else
			{
				throw new NotPresentException("The book: " + book.getTitle() + " is currently checked in.");
			}
		}
	}
	
	/**
	 * Sets the checked out status of the book.
	 * @param book
	 * @param status
	 * @throws NotPresentException
	 */
	public void setCheckedOutStatus(Book book, boolean status) throws NotPresentException
	{
		if(bookArchive.containsBook(book))
			book.setCheckedOutStatus(status);
		else
			throw new NotPresentException("The book's checked out status cannot be changed because it is not in the archive.");
	}
	
	/**
	 * Sets the check out date for a book.
	 * @param book
	 * @param date
	 * @throws NotPresentException
	 */
	public void setCheckOutDate(Book book, Date date) throws NotPresentException
	{
		if(bookArchive.containsBook(book))
			book.setCheckOutDate(date);
		else
			throw new NotPresentException("The book's check out date cannot be changed because it is not in the archive.");
	}
	
	/**
	 * Sets the return date for a book.
	 * @param book
	 * @param date 
	 * @throws NotPresentException
	 */
	public void setReturnDate(Book book, Date date) throws NotPresentException
	{
		if(bookArchive.containsBook(book))
			book.setReturnDate(date);
		else
			throw new NotPresentException("The book's return date cannot be changed because it is not in the archive.");
	}
	
	/**
	 * Returns the book archive.
	 * @return archive
	 */
	public BookArchive getBookArchive()
	{
		return bookArchive;
	}
	
	/**
	 * Returns the library fund object.
	 * @return fund
	 */
	public LibraryFund getLibraryFund()
	{
		return fund;
	}
	
	/**
	 * Charges the Patron a standard fee.
	 */
	public void charge(Patron patron, Date checkInDate)
	{
		try
		{
			fund.addEntry(patron, FEE, checkInDate, 0);
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Reads the file with the string name, then
	 * adds authors and books from a file.
	 * The format for the file is: fistName lastName numberOfYearsWriting title year
	 * @param fileName
	 */
	public void readFile(String fileName)
	{
		try
		{
			fileScan = new Scanner(new File(fileName));
			//Reads the information from the file and uses them as parameters to make an author object and book object.
			while(fileScan.hasNextLine())
			{
				String firstName = fileScan.next();
				String lastName = fileScan.next();
				int numberOfYearsWriting = Integer.parseInt(fileScan.next());
				Author author = makeAuthor(firstName, lastName, numberOfYearsWriting);
				String title = fileScan.next();
				int year = Integer.parseInt(fileScan.next());
				Book book = makeBook(title,author,year);
				getBookArchive().addEntry(author, book);
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
		catch(IsPresentException | IncorrectAuthorException e)
		{
			System.out.println(e.getMessage());
		}
		catch(NoSuchElementException e)
		{
			fileScan.close();
		}
	}
	
	/**
	 * Creates/Returns a new Book to be added to the book archive. 
	 * Primarily used for the readFile Method.
	 * Also used in the GUI when the library receives a new book individually.
	 * @param author
	 * @param title
	 * @param year
	 * @param id
	 * @return book
	 */
	public Book makeBook(String title, Author author, int year)
	{
		return new Book(title, author, year, 0); //The id number is assigned in the add method.
	}
	
	/**
	 * Creates/Returns a new Author to be added to the book archive. 
	 * Used for the readFile Method.
	 * Also used in the GUI when the library receives a new author individually.
	 * @param firstName
	 * @param lastName
	 * @param numberOfYearsWriting
	 * @return author
	 */
	public Author makeAuthor(String firstName, String lastName, int numberOfYearsWriting)
	{
		return new Author(firstName, lastName, numberOfYearsWriting);
	}
	
	/**
	 * Returns the info of the library.
	 * @return info
	 */
	public String toString()
	{
		String info = bookArchive.toString() + "\n" + fund.toString();
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
