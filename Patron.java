/**
 * This class creates a patron to be used in the library interface. 
 * The information that is used is specific to the interface's needs.
 * @author Justin Orr, Arianna Osar
 *
 */
public class Patron extends Person
{
	private int age;
	private String userName, passwd;
	
	/**
	 * Creates a Patron object using the super constructor from the Person parent class.
	 * @param firstName
	 * @param lastName
	 * @param age
	 */
	public Patron(String firstName, String lastName, int age, String username, String pass)
	{
		super(firstName,lastName);
		this.age = age;
		userName = username;
		passwd = pass;
	}
	
	/**
	 * Returns the user name of the patron.
	 * @return userName
	 */
	public String getUsername()
	{
		return userName;
	}
	
	/**
	 * Sets the user name for the patron.
	 * @param name
	 */
	public void setUsername(String name)
	{
		userName = name;
	}
	
	/**
	 * Returns the password for the patron.
	 * @return passwd
	 */
	public String getPasswd()
	{
		return passwd;
	}
	
	/**
	 * Sets the password for the patron.
	 * @param pass
	 */
	public void setPasswd(String pass)
	{
		passwd = pass;
	}
		
	/**
	 * Returns the age of the patron.
	 * @return age
	 */
	public int getAge()
	{
		return age;
	}
	
	/**
	 * Sets the age of the patron.
	 * @param age
	 */
	public void setAge(int age)
	{
		this.age = age;
	}
	
	/**
	 * Compares two patrons 
	 * @param Patron
	 * @return boolean
	 */
	public boolean equals(Patron patron)
	{
		if(super.equals(patron) && age == patron.getAge())
			return true;
		else
			return false;
	}
	
	/**
	 * Returns the patron's information
	 * @return info
	 */
	public String toString()
	{
		String info = super.toString() + "; Age: " + age;
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
