package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import database.DataBase;
import database.DataBaseFactory;
import database.SQLTables;
import dto.MenuItem;
import dto.Reservation;
import dto.Server;
import dto.Table;
import dto.TimeSlot;
import service_interfaces.AccountService;
import service_interfaces.ServiceUtils;

public class ServiceUtilsImpl implements ServiceUtils {

	// Private static instance of the class
	private static ServiceUtils instance;
	private DataBase db;
	private AccountService accountService;

	// Private constructor to prevent instantiation from outside the class
	private ServiceUtilsImpl() {
		db = DataBaseFactory.getDatabase();
		accountService = new AccountsServiceImpl();
	}

	// Public static method to get the instance of the class
	public static ServiceUtils getInstance() {
		// Create the instance if it does not exist
		if (instance == null) {
			instance = new ServiceUtilsImpl();
		}
		// Return the existing instance
		return instance;

	}

	@Override
	public List<Table> getTablesMatchingResReq(int capRequested) {
		List<Table> tables = db.getAllTables().stream().filter(table -> table.getCapacity() >= capRequested)
				.collect(Collectors.toList());

		return tables;
	}

	@Override
	public boolean registerTable(String id, int cap, String server) {
		Table table = new Table(id, cap, server);

		for (Table table2 : db.getAllTables()) {
			if (table.getId().equals(table2.getId())) {
				return false;
			}
		}

		db.insertRecord(SQLTables.TABLES_TABLE, table);

		return true;
	}

	@Override
	public boolean deleteTable(String id) {

		return db.deleteTable(id);

	}

	@Override
	public Map<String, String> getAllServersMap() {

		Map<String, String> map = new HashMap<>();
		for (Server server : db.getAllServers()) {

			map.put(server.getId(), server.getFirstName() + " " + server.getLastName());
		}

		return map;
	}

	@Override
	public List<TimeSlot> getAvailableTables(LocalDate givenDate, int capRequested) {
		List<TimeSlot> allSlots = db.getBusinessAccount().getAllTimeSlots();

		List<Table> tables = this.getTablesMatchingResReq(capRequested);

		List<Reservation> reservations = db.getReservationsForDate(givenDate);

		Set<TimeSlot> availableList = new HashSet<>(allSlots);

		for (TimeSlot timeSlot : allSlots) {
			int tablesAvailable = tables.size();
			for (Reservation reservation : reservations) {
				for (Table table : tables) {
					if ((reservation.getTableId().equals(table.getId()) && reservation.getTime().equals(timeSlot))) {
						System.out.println("Removing Time Slot " + timeSlot + " from available slots");
						tablesAvailable--;
					}
				}
			}

			if (tablesAvailable == 0) {
				availableList.remove(timeSlot);
			}
		}

		System.out.println("Tables Available Are: " + tables.toString());
		System.out.println("Reservations In System Are: " + reservations.toString());
		System.out.println("Available Time Slots Are: " + availableList + "\n\n");

		return new ArrayList<>(availableList);

	}
	
	@Override
	public Server registerServer (String firstName, String lastName) {
		Server server = new Server(UUID.randomUUID().toString(), firstName, lastName);
		
		if (db.insertRecord(SQLTables.SERVERS_TABLE, server))
		{
			return server;
		}else {
			return null;
		}
		
	}

	@Override
	public List<Server> getAllServers() {
		return db.getAllServers();
		
	}

	@Override
	public boolean deleteServer(String id) {
		return db.deleteServer(id);
	}

	@Override
	public List<MenuItem> getAllMenuItems() {
		return db.getAllMenuItems();
	}
	


}
