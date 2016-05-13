/**
 * This class creates a book object for the library database.
 * @author Justin Orr, Arianna Osar
 *
 */
public class Book 
{
	private Author author;
	private int id, year;
	private String title;
	private boolean checkedOutStatus;
	private Date checkOutDate, returnDate;
	
	/**
	 * Creates a specific book with specific information.
	 * @param title
	 * @param author
	 * @param year
	 * @param id
	 */
	public Book(String title, Author author, int year, int id)
	{
		this.title = title;
		this.author = author;
		this.year = year;
		this.id = id;
		checkedOutStatus = false;
		try
		{
			checkOutDate = new Date(2016,1,1);
			returnDate = new Date(2016,1,1);
		}
		catch(InvalidDateException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Returns the title of the book.
	 * @return title
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Returns the author of the book.
	 * @return author
	 */
	public Author getAuthor()
	{
		return author;
	}
	
	/**
	 * Returns the year of the book.
	 * @return year
	 */
	public int getYear()
	{
		return year;
	}
	
	/**
	 * Returns the id of the book.
	 * @return id
	 */
	public int getID()
	{
		return id;
	}
	
	/**
	 * Returns the checked out status of the book.
	 * @return checkedOutStatus
	 */
	public boolean getCheckedOutStatus()
	{
		return checkedOutStatus;
	}
	
	/**
	 * Returns the check out date.
	 * @return date
	 */
	public Date getCheckOutDate()
	{
		return checkOutDate;
	}
	
	/**
	 * Returns the return date.
	 * @return date
	 */
	public Date getReturnDate()
	{
		return returnDate;
	}
	
	/**
	 * Sets the title for the book
	 * @param title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	/**
	 * Sets the Author of the book.
	 * @param author
	 */
	public void setAuthor(Author author)
	{
		this.author = author;
	}
	
	/**
	 * Sets the year of the book.
	 * @param year
	 */
	public void setYear(int year)
	{
		this.year = year;
	}
	
	/**
	 * Sets the id of the book.
	 * @param id
	 */
	public void setID(int id)
	{
		this.id = id;
	}
	
	/**
	 * Sets the checked out status of the book.
	 * @param checkedOutStatus
	 */
	public void setCheckedOutStatus(boolean checkedOutStatus)
	{
		this.checkedOutStatus = checkedOutStatus;
	}
	
	/**
	 * Sets the check out date.
	 * @param Date
	 */
	public void setCheckOutDate(Date date)
	{
		checkOutDate = date;
	}
	
	/**
	 * Sets the return date.
	 * @param date
	 */
	public void setReturnDate(Date date)
	{
		returnDate = date;
	}
	
	/**
	 * Compares two books.
	 * @param Book
	 * @return boolean
	 */
	public boolean equals(Book book)
	{
		if(book == null)
		{
			return false;
		}
		if(title.compareTo(book.getTitle()) == 0 && author.equals(book.getAuthor()) && year == book.getYear() && id == book.getID())
			return true;
		else
			return false;
	}
	
	/**
	 * Returns the info of the book.
	 * @return info
	 */
	public String toString()
	{
		String info = "Title: " + title + "; Author: " + author + "; Year " + year + "; ID#: " + id;
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
