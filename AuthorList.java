import java.util.ArrayList;
/**
 * Creates a list of authors for the library's book archive.
 * @author Justin Orr
 *
 */
public class AuthorList 
{
	private ArrayList<Author> authorList;
	
	/**
	 * Constructs an Author List
	 */
	public AuthorList()
	{
		authorList = new ArrayList<Author>();
	}
	
	/**
	 * Returns the authorList
	 * @return authorList
	 */
	public ArrayList<Author> getAuthorList()
	{
		return authorList;
	}
	
	/**
	 * Sets the authorList
	 * @param authorList
	 */
	public void setAuthorList(ArrayList<Author> authorList)
	{
		this.authorList = authorList;
	}
	
	/**
	 * Adds an author to the list.
	 * @param Author
	 */
	public void addAuthor(Author author) throws IsPresentException
	{
		if(!isPresent(author))
			authorList.add(author);
		else
			throw new IsPresentException("Author already exists.");
	}
	
	/**
	 * Returns the author by name
	 * @param name
	 */
	public Author getAuthor(String name) throws NotPresentException
	{
		for(Author a: authorList)
		{
			if(a.getName().compareTo(name)==0)
			{
				return a;
			}
		}
		throw new NotPresentException("No Author Present");
	}
	
	/**
	 * Returns the author based on position.
	 * @param index
	 */
	public Author getAuthor(int index)
	{
		try
		{
			return authorList.get(index);
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	/**
	 * Returns the author's index within the list. Returns -1 if not present
	 * @param Author
	 * @return integer
	 */
	public int getAuthorIndex(Author author)
	{
		return authorList.indexOf(author);
	}
	
	/**
	 * Remove's the author from the list
	 * @param author
	 */
	public void removeAuthor(Author author) throws NotPresentException
	{
		if(isPresent(author))
			authorList.remove(author);
		else
			throw new NotPresentException("Author not Present for removal.");
	}
	
	/**
	 * Remove's the author from the list.
	 * @param index
	 */
	public void removeAuthor(int index) throws NotPresentException
	{
		if(authorList.get(index).equals(null) || index > size()-1)
			throw new NotPresentException("Author not Present for removal.");
		else
			authorList.remove(index);			
	}
	
	/**
	 * Returns the size of the authorList
	 * @return size
	 */
	public int size()
	{
		return authorList.size();
	}
	
	/**
	 * Returns whether the list is empty or not.
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		return authorList.isEmpty();
	}
	
	/**
	 * Compares two lists of authors
	 * @param authorList
	 */
	public boolean equals(AuthorList authorList)
	{
		if(this.size() != authorList.size())
			return false;
		else
		{
			for(int i = 0; i < authorList.size(); i++)
			{
				if(!authorList.getAuthor(i).equals(this.getAuthor(i)))
				{
					return false;
				}
			}
			return true;
		}
	}
	
	/**
	 * Returns the info from the author list.
	 * @param info
	 */
	public String toString()
	{
		String info = "Author List Size: " + authorList.size();
		return info;
	}
	
	/**
	 * Returns a boolean over whether the author already exist inside the list
	 * @param author
	 * @return boolean 
	 */
	public boolean isPresent(Author author)
	{
		for(Author a: authorList)
		{
			if(a.equals(author))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Prints out the authors from the list.
	 */
	public void print()
	{
		System.out.println("Authors:");
		for(int i = 0; i < authorList.size(); i++)
		{
			System.out.println(authorList.get(i).toString());
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
