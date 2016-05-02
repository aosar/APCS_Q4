/**
 * This class creates an Author object.
 * This author class utilizes information for the library interface.
 * @author Justin Orr, Arianna Osar
 *
 */
public class Author extends Person
{
	private int numberOfYearsWriting;
	
	/**
	 * Creates a Author object using the super constructor from the Person parent class.
	 * @param firstName
	 * @param lastName
	 * @param numberOfYearsWriting
	 */
	public Author(String firstName, String lastName, int numberOfYearsWriting)
	{
		super(firstName,lastName);
		this.numberOfYearsWriting = numberOfYearsWriting;
	}
	
	/**
	 * Returns the number of years the Author has been writing.
	 * @return age
	 */
	public int getNumberOfYearsWriting()
	{
		return numberOfYearsWriting;
	}
	
	/**
	 * Sets the number of years writing for the Author.
	 * @param numberOfYearsWriting
	 */
	public void setNumberOfYearsWriting(int numberOfYearsWriting)
	{
		this.numberOfYearsWriting = numberOfYearsWriting;
	}
	
	/**
	 * Compares two Authors 
	 * @param Author
	 * @return boolean
	 */
	public boolean equals(Author Author)
	{
		if(this.equals(Author) && numberOfYearsWriting == Author.getNumberOfYearsWriting())
			return true;
		else
			return false;
	}
	
	/**
	 * Returns the Author's information
	 * @return info
	 */
	public String toString()
	{
		String info = super.toString() + "Number of Years of Writing: " + numberOfYearsWriting;
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
