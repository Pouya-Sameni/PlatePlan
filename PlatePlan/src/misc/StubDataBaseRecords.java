package misc;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import dto.Business;
import dto.Customer;
import dto.Reservation;
import dto.Server;
import dto.Table;

public class StubDataBaseRecords {
	public static List<Customer> customers = new ArrayList<Customer>(
			Arrays.asList(new Customer("john", "john", "doe", "password"),
					new Customer("janedoe@email.com", "jane", "doe", "password"),
					new Customer("max@email.com", "max", "payne", "password")));

	public static Business business = new Business("alfredo", "password");


	public static List<Server> servers = new ArrayList<Server>(Arrays.asList(

			new Server(UUID.randomUUID().toString(), "pouya", "sameni"),
			new Server(UUID.randomUUID().toString(), "peter", "parker"),
			new Server(UUID.randomUUID().toString(), "chris", "evans")

	));

	public static List<Table> tables = new ArrayList<Table>(Arrays.asList(
			new Table("1", 4),
			new Table("2", 2),
			new Table("3", 2),
			new Table("4", 6),
			new Table("5", 8),
			new Table("6", 4)
	));
	
	
	public static List<Reservation> reservations = new ArrayList<Reservation>();
	
}
