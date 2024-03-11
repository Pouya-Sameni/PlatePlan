package database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import dto.Business;
import dto.Customer;
import dto.Feedback;
import dto.MenuItem;
import dto.Reservation;
import dto.Server;
import dto.Table;
import misc.StubDataBaseRecords;

public class DataBaseStubImpl implements DataBase {

	private static DataBaseStubImpl dataBaseInstance;

	private DataBaseStubImpl() {
	}

	public static synchronized DataBaseStubImpl getInstance() {
		if (dataBaseInstance == null) {
			dataBaseInstance = new DataBaseStubImpl();
		}
		return dataBaseInstance;
	}

	@Override
	public boolean insertRecord(String tableName, Object object) {
		// Simulate inserting a record into the database
		// (in a real database, you would execute SQL insert statements)
		try {
			if (tableName.equals(SQLTables.RESERVATION_TABLE)) {
				Reservation reservation = (Reservation) object;

				StubDataBaseRecords.reservations.add(reservation);

			} else if (tableName.equals(SQLTables.TABLES_TABLE)) {
				Table table = (Table) object;
				StubDataBaseRecords.tables.add(table);
			} else if (tableName.equals(SQLTables.ACCOUNTS_TABLE)) {
				Customer customer = (Customer) object;
				try {
					getCustomerAccount(customer.getEmail());
					return false;
				} catch (Exception e) {
					StubDataBaseRecords.customers.add(customer);

				}
			}

			System.out.println("Inserting record into " + tableName + ": " + object.toString());

			return true; // Return true to indicate success

		} catch (Exception e) {
			System.out.println("Error inserting Record + " + object.toString());

		}
		return false;

	}

	@Override
	public Customer getCustomerAccount(String email) throws AccountNotFoundException {
		List<Customer> customers = StubDataBaseRecords.customers;

		try {

			Customer customerFound = customers.stream().filter(customer -> customer.getEmail().equalsIgnoreCase(email))
					.findFirst()
					.orElseThrow(() -> new AccountNotFoundException("No customer with the given email " + email));
			return customerFound;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountNotFoundException("No customer with the given email " + email);
		}
	}

	@Override
	public Business getBusinessAccount() {
		return StubDataBaseRecords.business;
	}

	@Override
	public List<Table> getAllTables() {
		return StubDataBaseRecords.tables;
	}

	@Override
	public List<Server> getAllServers() {
		return StubDataBaseRecords.servers;
	}

	@Override
	public List<Reservation> getAllReservations() {
		return StubDataBaseRecords.reservations != null ? StubDataBaseRecords.reservations
				: new ArrayList<Reservation>();
	}

	@Override
	public List<Reservation> getReservationsForDate(LocalDate date) {

		System.out.println(date + " All Reservations: " + StubDataBaseRecords.reservations);
		return StubDataBaseRecords.reservations.stream().filter(reservation -> reservation.getDate().equals(date))
				.collect(Collectors.toList());

	}

	@Override
	public List<Reservation> getCustomerReservations(String email) throws AccountNotFoundException {
		Customer customer = this.getCustomerAccount(email);

		if (customer != null) {

			List<Reservation> reservations = new ArrayList<Reservation>();
			for (Reservation resId : StubDataBaseRecords.reservations) {
				reservations.add(getReservationWithId(resId.getId()));
			}
			reservations.removeAll(Collections.singleton(null));
			return reservations;
		}
		throw new AccountNotFoundException("No customer with the given email " + email);
	}

	@Override
	public Reservation getReservationWithId(String id) {
		return StubDataBaseRecords.reservations.stream().filter(reservation -> reservation.getId().equals(id))
				.findFirst().orElse(null);

	}

	@Override
	public List<MenuItem> getAllMenuItems(String table) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void publishCustomerMenu() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteDataBaseEntry(String table, String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDataBaseEntry(Object object, String table) {
		// TODO Auto-generated method stub
		return false;
	}

}
