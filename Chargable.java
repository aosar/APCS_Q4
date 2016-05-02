/**
 * This interface is used with objects that allow charges in 
 * terms of currency to be placed on other objects.
 * @author Justin Orr
 *
 */
public interface Chargable 
{
	public double charge(Patron patron, double amount, Date date);
}
