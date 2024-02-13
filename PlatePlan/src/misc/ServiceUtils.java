package misc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    	List<TimeSlot> avaiList = db.getBusinessAccount().getAllTimeSlots();
    	
    	List<Table> tables = db.getAllTables();
    	
    	tables = tables.stream().filter(table -> table.getCapacity() - capRequested <= 2).collect(Collectors.toList());
    	
    	List<Reservation> reservations = db.getReservationsForDate(givenDate);
    	
    	
    	List<Reservation> temp = new ArrayList<Reservation>();
    	for (Reservation reservation: reservations)
    	{
    		for (Table table: tables) {
    			if (!table.getId().equals(reservation.getTable().getId()))
    			{
    				temp.add(table);
    			}
    		}
    	}
    		
    	
    	List<Reservation> filteredReservations = reservations.stream()
    		    .filter(reservation -> tables.stream()
    		        .anyMatch(table -> table.getId().equals(reservation.getTable().getId())))
    		    .collect(Collectors.toList());
    	
    	
    	
		return null;
    	
    }


}
