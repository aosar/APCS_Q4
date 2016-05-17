import java.util.ArrayList;

/**
 * A class that holds a list of patrons.
 * @author Justin Orr
 *
 */
public class PatronList extends List<Patron>
{
	/**
	 * Default constructor
	 */
	public PatronList()
	{
		super();
	} 
	
	/**
	 * Sorts the patron list by user name.
	 */
	public void sortList()
	{
		ArrayList<Patron> patronList = super.getArrayList();
		
		for(int i = 0; i < patronList.size(); i++)
		{
			for(int j = 0; j < patronList.size(); j++)
			{
				if(patronList.get(j).toString().compareTo(patronList.get(i).toString()) < 0)
				{
					Patron p = patronList.get(j);
					patronList.set(j, patronList.get(i));
					patronList.set(i, p);
				}
			}
		}
		
		super.setArrayList(patronList);
	}
	
	/**
	 * Returns the author by name
	 * @param name
	 */
	public Patron getPatron(String name) throws NotPresentException
	{
		for(Patron p: super.getArrayList())
		{
			if(p.getName().compareTo(name)==0)
			{
				return p;
			}
		}
		throw new NotPresentException("No Patron Present");
	}
	
	/**
	 * Searches the patron list for a patron with the specified credentials.
	 * @param username
	 * @param password
	 * @return patron
	 * @throws NotPresentException
	 */
	public Patron searchPatronList(String username, String password) throws NotPresentException
	{
		for(Patron p: super.getArrayList())
		{
			if(p.getUsername().compareTo(username)==0 && p.getPasswd().compareTo(password)==0)
				return p;
		}
		throw new NotPresentException("There is no one with those credentials availible.");
	}
	
	/**
	 * Checks to see if there is a patron with the specified credentials.
	 * @param username
	 * @param password
	 * @return boolean
	 */
	public boolean checkCredentials(String username, String password)
	{
		for(Patron p: super.getArrayList())
		{
			if(p.getUsername().compareTo(username)==0 && p.getPasswd().compareTo(password)==0)
				return true;
		}
		return false;
	}
	
	/**
	 * Displays the person information in a GUI.
	 */
	public void display()
	{
		//Execute GUI code.
	}
}
