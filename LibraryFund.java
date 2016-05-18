import java.util.ArrayList;

/**
 * This class creates a fund object that organizes currency and funding.
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
			patronsList.add(new Patron("username","password", 0, "Generic", "Patron"));
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
	public ArrayList<Patron> getPatron()
	{
		return patronsList;
	}
	
	/**
	 *  Adds money from to the funds.
	 *  @param patron
	 *  @param amount
	 *  @param date
	 */
	public void addMoney(Patron patron, double amount, Date date)
	{
		patronsList.add(patron);
		money.add(amount);
		dates.add(date);
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
	 * Displays the person information in a GUI.
	 */
	public void display()
	{
		//Execute GUI code.
	}
	
}
