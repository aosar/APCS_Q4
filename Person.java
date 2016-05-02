/**
 * This class is a generic class for a Person object.
 * @author Justin Orr, Arianna Osar
 *
 */
public class Person 
{
	private String firstName, lastName;
	
	/**
	 * Constructs a Person object.
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Returns the first name of the person.
	 * @return firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * Returns the last name of the person.
	 * @return lastName
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * Sets the first name of the person.
	 * @param name
	 */
	public void setFirstName(String name)
	{
		firstName = name;
	}
	
	/**
	 * Sets the last name of the person.
	 * @param name
	 */
	public void setLastName(String name)
	{
		lastName = name;
	}
	
	/**
	 * Compare's two people.
	 * @param Person
	 * @return boolean
	 */
	public boolean equals(Person person)
	{
		if(firstName.compareTo(person.getFirstName())==0 && lastName.compareTo(person.getLastName())==0)
			return true;
		else
			return false;
	}
	
	/**
	 * Returns the Peron's info 
	 * @return String
	 */
	public String toString()
	{
		String info = "" + firstName + " " + lastName;
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
