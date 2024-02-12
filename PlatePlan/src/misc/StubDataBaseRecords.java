package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import dto.Business;
import dto.Customer;
import dto.Reservation;
import dto.Server;
import dto.Table;
public class StubDataBaseRecords {
	public static List<Customer> customers = new ArrayList<Customer>(Arrays.asList(
			new Customer("johndoe@email.com", "john", "doe", "password"),
			new Customer("janedoe@email.com", "jane", "doe", "password"),
			new Customer("max@email.com", "max", "payne", "password")));
	
	public static Business business = new Business ("alfredo@email.com", "password");
	
	// Creates new server object
	public static Server server1 = new Server("Joe","Bob");
	
	// Creates new table object
	public static Table table1 = new Table(3,server1);
	
	// Creates Fake Reservations ArrayList
	public static ArrayList<Reservation> reservationList = new ArrayList<Reservation>(Arrays.asList(
			new Reservation("1","Vegan", server1, table1),
			new Reservation("3", "Allergic to nuts", server1, table1),
			new Reservation("2","Meat Only",server1, table1)));
}
