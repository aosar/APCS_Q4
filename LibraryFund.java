import java.util.ArrayList;

/**
 * This class creates a fund datesect that organizes currency and funding.
 * @author Justin Orr, Arianna Osar
 *
 */
public class LibraryFund 
{
	private double totalFunds;
	private ArrayList<Object> records; //Holds the records for how much money was added to the fund or removed and keeps dates for the transactions.
	private ArrayList<Double> money; //Contains the money values for the records.
	private ArrayList<Date> dates; //Contains the dates for each of the transactions.
	private ArrayList<Patron> patronsList; //Contains the patrons for each of the transactions.
	
	/**
	 * Constructs a fund object with an initial amount.
	 * @param amount
	 * @throws LessThanZeroException
	 */
	public LibraryFund(double amount) throws LessThanZeroException
	{
		if(amount < 0)
			{throw new LessThanZeroException("Invalid Fund Amount");}
		else
			{totalFunds = amount;}
		createRecords();
	}
	
	/**
	 * Creates the records by placing the money and dates arrayLists within the records ArrayList.
	 * THus creating a 3 dimensional array.
	 */
	private void createRecords()
	{
		money = new ArrayList<Double>();
		dates = new ArrayList<Date>();
		patronsList = new ArrayList<Patron>();
		//Gives the arrays generic elements in order to reference a size so that it won't be null.
		try
		{
			money.add(0.0);
			dates.add(new Date(2016,1,1));
			patronsList.add(new Patron("Generic", "Patron", 0, "UserName", "PassWord"));
		}
		catch(InvalidDateException e)
		{
			System.out.println(e.getMessage());
		}
		records = new ArrayList<Object>();
		records.add(dates);
		records.add(patronsList);
		records.add(money);
	}
	
	/**
	 * Returns the money list.
	 * @return moneyList	
	 */
	public ArrayList<Double> getMoneyList()
	{
		return money;
	}
	
	/**
	 * Returns the date list.
	 * @return dates
	 */
	public ArrayList<Date> getDates()
	{
		return dates;
	}
	
	/**
	 * Returns the patron's list.
	 * @return patron
	 */
	public ArrayList<Patron> getPatronsList()
	{
		return patronsList;
	}
	
	/**
	 * Returns the total funds.
	 * @return totalFunds
	 */
	public double getTotalFunds()
	{
		return totalFunds;
	}
	
	/**
	 *  Adds money from to the funds while keeping the dates in order.
	 *  @param patron
	 *  @param amount
	 *  @param date
	 *  @param i //Index to start begin the checks from. TYpically should always be 0.
	 */
	public boolean addEntry(Patron patron, double amount, Date date, int i) throws IndexOutOfBoundsException
	{
		boolean firstTerm = false;
		boolean lastTerm = false;
		if(dates.isEmpty())
		{
			dates.add(date);
			return true;
		}
		sort();
		
		if(i == dates.size() - 1)
			lastTerm = true;
		else if(i == 0)
			firstTerm = true;
		
		if(i > dates.size()-1 || i < 0)//If i is < 0 or greater than the size of the list.
			throw new IndexOutOfBoundsException("Second method argument is not within the size of the list.");
		
		if(dates.toString().compareTo(dates.get(i).toString()) == 0)//If dates are equal.
		{
			dates.add(date);
			patronsList.add(patron);
			money.add(amount);
			totalFunds += amount;	
		}
		else if(dates.toString().compareTo(dates.get(i).toString()) > 0)//For when the dates is greater than or lower in the list.
		{
			if(lastTerm)
			{
				dates.add(date);
				patronsList.add(patron);
				money.add(amount);
				totalFunds += amount;
			}
			else
			{
				if(dates.toString().compareTo(dates.get(i + 1).toString()) > 0)//Checks the term in front of it.
					return addEntry(patron, amount, date, i+1);
				else
					dates.add(i+1, date);
					patronsList.add(i+1, patron);
					money.add(i+1, amount);
					totalFunds += amount;
			}
		}
		else if(dates.toString().compareTo(dates.get(i).toString()) < 0)//For when the Object is less than or higher in the list.
		{
			if(firstTerm)
			{
				dates.add(0, date);
				patronsList.add(0, patron);
				money.add(0, amount);
				totalFunds += amount;
			}
			else
			{
				if(dates.toString().compareTo(dates.get(i - 1).toString()) < 0)//Checks the term in front of in case the second argument is greater than 0. Hence checking in the middle of the list instead of the beginning.
					return addEntry(patron, amount, date, i-1);
				else
					dates.add(i-1, date);
					patronsList.add(i-1, patron);
					money.add(i-1, amount);
					totalFunds += amount;
			}
		}
		
		if(dates.contains(dates)== true)//Checks to make sure the datesect was added.
			return true;
		else
			return false;
				
	}
	
	/**
	 * Sorts the records using the bubble sort algorithm.
	 */
	public void sort()
	{
		//i = 1 because the first entry acts as the title for printing the records.
		for(int i = 1; i < dates.size(); i++)
		{
			String d1 = dates.get(i).toString();
			for(int j = i+1; j < dates.size(); j++)
			{
				String d2 = dates.get(j).toString();
				if(d2.compareTo(d1) < 0)
				{
					Date temp = dates.get(i);
					dates.set(i, dates.get(j));
					dates.set(j, temp);
					
					double temp2 = money.get(i);
					money.set(i, money.get(j));
					money.set(j, temp2);
					
					Patron temp3 = patronsList.get(i);
					patronsList.set(i, patronsList.get(j));
					patronsList.set(j, temp3);
				}
			}
		}
	}
	
	
	/**
	 * Compares two library fund objects
	 * @param libraryFund
	 * @param boolean
	 */
	public boolean equals(LibraryFund fund)
	{
		if(totalFunds == fund.getTotalFunds() && compareArrays(getMoneyList(), fund.getMoneyList()) && compareArrays(getPatronsList(), fund.getPatronsList()) && compareArrays(getDates(), fund.getDates()))
			return true;
		else
			return false;
	}
	
	/**
	 * Returns the information from the funding archive.
	 * @return info
	 */
	public String toString()
	{
		String info = "Total Funding: " + totalFunds + "; Archive list size: " + patronsList.size();
		return info;
	}
	
	/**
	 * Prints the record's information
	 */
	public void printRecords()
	{
		System.out.println("Date:\tPatron's Name:\tAmount:");
		for(int i = 0; i < dates.size(); i++)
		{
			System.out.println(dates.get(i).toString() + "  " + patronsList.get(i).getName() + "  " + money.get(i));
		}
	}
	
	/**
	 * Compares the contents of two Array Lists.
	 * @param ArrayList
	 * @return boolean
	 */
	public boolean compareArrays(ArrayList list1, ArrayList list2)
	{
		if(list1.size() != list2.size())
			return false;
		else
		{
			for(int i = 0; i < list1.size(); i++)
			{
				if(!list1.get(i).equals(list2.get(i)))
				{
					return false;
				}
			}
			return true;
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
