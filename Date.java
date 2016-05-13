/**
 * Creates a date using the format of year, month, day.
 * @author Justin Orr, Arianna Osar
 *
 */
public class Date 
{
	private int year, month, day;
	
	/**
	 * Constructs a date object with the format of the year, then month, then the day.
	 * @param year
	 * @param month
	 * @param day
	 * @throw InvalidDateException
	 */
	public Date(int year, int month, int day) throws InvalidDateException
	{
		setYear(year);	
		setMonth(month);
		setDay(day);
	}
	
	/**
	 * Returns the year.
	 * @return year
	 */
	public int getYear()
	{
		return year;
	}
	
	/**
	 * Returns the month.
	 * @return month
	 */
	public int getMonth()
	{
		return month;
	}
	
	/**
	 * Returns the day.
	 * @return day
	 */
	public int getDay()
	{
		return day;
	}
	
	/**
	 * Sets the year.
	 * @param year
	 * @throws InvalidDateException
	 */
	public void setYear(int year) throws InvalidDateException
	{
		if(!validYear(year))
			throw new InvalidDateException("Invalid year");
		else
			this.year = year;
	}
	
	/**
	 * Sets the month.
	 * @param month
	 * @throws InvalidDateException
	 */
	public void setMonth(int month) throws InvalidDateException
	{
		if(!validMonth(month))
			throw new InvalidDateException("Invalid month");
		else 
			{this.month = month; update();}
	}
	
	/**
	 * Sets the day.
	 * @param day
	 * @throws InvalidDateException
	 */
	public void setDay(int day) throws InvalidDateException
	{
		if(!validDay(day))
			throw new InvalidDateException("Invalid day");
		else
			this.day = day;
	}
	
	/**
	 * Checks the year to see if it is a valid year.
	 * @param year
	 * @return boolean
	 */
	private boolean validYear(int year) throws InvalidDateException
	{
		if(year < 1850 || year > 2016)
			return false;
		else
			return true;
	}
	
	/**
	 * Checks the month to see if it is a valid month.
	 * @param month
	 * @return boolean
	 */
	private boolean validMonth(int month)
	{
		if(month < 1 || month > 12)
			return false;
		else
			return true;
	}
	
	/**
	 * Checks the day to see if it is a valid day.
	 * @param day
	 * @return boolean
	 */
	private boolean validDay(int day)
	{
		if(day < 1 || day > 31)
		{
			return false;
		}
		else if(month == 2)
		{
			if(day > 28)
				return false;
			else
				return true;
		}
		else if(month == 4 || month ==6 || month == 9 || month == 11)
		{
			if(day > 30)
				return false;
			else
				return true;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Formats the date.
	 * @return date
	 */
	private String formatDate()
	{
		String date = "" + year + "/";
		if(month < 10)
		{
			date += "0" + month + "/";
		}
		else
		{
			date += month + "/";
		}
		
		if(day < 10)
		{
			date += "0" + day;
		}
		else
		{
			date += day;
		}
		return date;
	}
	
	/**
	 * Updates the date based on the month.
	 */
	private void update()
	{
		try
		{
			if(month == 2)
			{
				if(day > 28)
					setDay(1);
			}
			else if(month == 4 || month ==6 || month == 9 || month == 11)
			{
				if(day > 30)
					setDay(1);
			}
		}
		catch(InvalidDateException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Compares two dates
	 * @param date
	 * @return boolean
	 */
	public boolean equals(Date date)
	{
		if(year == date.getYear() && month == date.getMonth() && day == date.getDay())
			return true;
		else
			return false;
	}
	
	/**
	 * Returns the specially formatted date.
	 * @return date
	 */
	public String toString()
	{
		return formatDate();
	}
	
	/**
	 * Displays the person information in a GUI.
	 */
	public void display()
	{
		//Execute GUI code.
	}
}
