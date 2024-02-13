package misc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import database.DataBase;
import database.DataBaseFactory;
import dto.Business;
import dto.Reservation;
import dto.Table;
import dto.TimeSlot;
import service_interfaces.AccountService;
import service_interfaces.ReservationService;
import services.AccountsServiceImpl;
import services.ReservationServiceImpl;

public class ServiceUtils {

	// Private static instance of the class
	private static ServiceUtils instance;
	private DataBase db;
	private AccountService accountService;
	private ReservationService reservationService;

	// Private constructor to prevent instantiation from outside the class
	private ServiceUtils() {
		db = DataBaseFactory.getDatabase();
		accountService = new AccountsServiceImpl();
		reservationService = new ReservationServiceImpl();
	}

	// Public static method to get the instance of the class
	public static ServiceUtils getInstance() {
		// Create the instance if it does not exist
		if (instance == null) {
			instance = new ServiceUtils();
		}
		// Return the existing instance
		return instance;

	}

	public List<TimeSlot> getAvailableTables (LocalDate givenDate, int capRequested)
    {
    	List<TimeSlot> allSlots = db.getBusinessAccount().getAllTimeSlots();
    	    	
    	 List<Table> tables = db.getAllTables().stream().filter(table -> table.getCapacity() > capRequested).collect(Collectors.toList());
    	
    	List<Reservation> reservations = db.getReservationsForDate(givenDate);
    	
    	Set<TimeSlot> availableList = new HashSet<>(allSlots);


    	for (TimeSlot timeSlot: allSlots)
    	{
    		
    		for (Reservation reservation: reservations)
    		{
    			for (Table table: tables)
    			{
    				if ((reservation.getTable().getId().equals(table.getId()) && reservation.getTime().equals(timeSlot)))
    				{
    					availableList.remove(timeSlot);
    				}
    			}
    		}
    	}
    	
    	System.out.println("Tables Available Are: " + tables.toString());
    	System.out.println("Reservations In System Are: " + reservations.toString());
    	System.out.println("Available Time Slots Are: " + availableList + "\n\n");

		return new ArrayList<>(availableList);
    	
    }

}
