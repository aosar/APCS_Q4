import java.util.ArrayList;

/**
 * Creates a generic list of objects and provides methods to navigate them.
 * @author Justin Orr
 *
 */
public class List<T>
{
	private ArrayList<T> list;
	
	/**
	 * Default Generic Constructor.
	 */
	public List()
	{
		list = new ArrayList<T>();
	}
	
	/**
	 * Returns the list.
	 * @return arrayList
	 */
	public ArrayList<T> getArrayList()
	{
		return list;
	}
	
	/**
	 * Sets the list equal to another list.
	 * @param list
	 */
	public void setArrayList(ArrayList<T> list)
	{
		this.list = list;
	}
	
	/**
	 * Adds an object to the list.
	 * @param object
	 */
	public void add(T object) throws IsPresentException
	{
		if(!isPresent(object))
			list.add(object); 
		else
			throw new IsPresentException("Object:" + object + "already exists.");
	}
	
	/**
	 * Adds an array of objects to the list of the same data type.
	 * @param ArrayList<T>
	 */
	public void add(ArrayList<T> array) throws IsPresentException
	{
		for(T obj: array)
		{
			add(obj);
		}
	}
	
	/**
	 * Returns the object based on position.
	 * @param index
	 */
	public T getObject(int index) throws IndexOutOfBoundsException
	{
		try
		{
			return list.get(index);
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	/**
	 * Returns the book's index within the list.
	 * @param obj
	 * @return index
	 */
	public int getObjectIndex(T obj)
	{
		return list.indexOf(obj);
	}
	
	/**
	 * Remove's the book from the list
	 * @param book
	 */
	public void removeObject(T obj)  throws NotPresentException
	{
		if(isPresent(obj))
			list.remove(obj);
		else
			throw new NotPresentException("" + obj + "is not Present for removal.");
	}
	
	/**
	 * Remove's the object from the list.
	 * @param index
	 */
	public void removeObject(int index) throws NotPresentException
	{
		if(list.get(index).equals(null) || index > size()-1)
			throw new NotPresentException("Object not Present for removal.");
		else
			list.remove(index);			
	}
	
	/**
	 * Returns the size of the bookList
	 * @return size
	 */
	public int size()
	{
		return list.size();
	}
	
	/**
	 * Compares two lists of books
	 * @param bookList
	 */
	public boolean equals(List<T> list2)
	{
		if(this.size() != list2.size())
			return false;
		else
		{
			for(int i = 0; i < list.size(); i++)
			{
				if(!list2.getObject(i).equals(this.getObject(i)))
				{
					return false;
				}
			}
			return true;
		}
	}
	
	/**
	 * Returns whether the list is empty or not.
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	/**
	 * Returns the info from the book list.
	 * @param info
	 */
	public String toString()
	{
		String info = "List Size: " + list.size();
		return info;
	}
	
	/**
	 * Returns a boolean over whether the book already exist inside the list
	 * @param book
	 * @return boolean 
	 */
	public boolean isPresent(T obj)
	{
		for(T obj2: list)
		{
			if(obj.equals(obj2))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Prints out the books from the list.
	 */
	public void print()
	{
		System.out.println("Objects:");
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i).toString());
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
