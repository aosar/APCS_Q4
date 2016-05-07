/**
 * This class creates a patron to be used in the library interface. 
 * The information that is used is specific to the interface's needs.
 * @author Justin Orr, Arianna Osar
 *
 */
public class Patron extends Person
{
	private int age;
	private int username;
	private int passwd;
	
	/**
	 * Creates a Patron object using the super constructor from the Person parent class.
	 * @param firstName
	 * @param lastName
	 * @param age
	 */
	public Patron(String firstName, String lastName, int age,String usrname,String pass)
	{
		super(firstName,lastName);
		this.age = age;
		username = usrname;
		passwd = pass;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String name){
		
		username = name;
	}
	public String getPasswd(){
		return passwd;
	}
	public void setPasswd(String pass){
		
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
		if(this.equals(patron) && age == patron.getAge())
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
		String info = super.toString() + "Age: " + age;
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
