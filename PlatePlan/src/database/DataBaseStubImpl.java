package database;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import dto.Business;
import dto.Customer;
import dto.Reservation;
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
    public boolean insertRecord(String tableName, String values) {
        // Simulate inserting a record into the database
        // (in a real database, you would execute SQL insert statements)
        System.out.println("Inserting record into " + tableName + ": " + values);
        return true; // Return true to indicate success
    }

    @Override
    public Customer getCustomerAccount(String email) throws AccountNotFoundException {
        List<Customer> customers = StubDataBaseRecords.customers;

        try {
        	
            Customer customerFound = customers.stream()
                    .filter(customer -> customer.getEmail().equalsIgnoreCase(email)).findFirst()
                    .orElseThrow(() -> new AccountNotFoundException("No customer with the given email " + email));
            return customerFound;
        } catch (Exception e) {
            e.printStackTrace();
            throw new AccountNotFoundException("No customer with the given email " + email);
        }
    }

    @Override
    public List<Reservation> getCustomerReservations(String email) throws AccountNotFoundException {
        Customer customer = this.getCustomerAccount(email);

        if (customer != null) {
            return customer.getReservations();
        }
        throw new AccountNotFoundException("No customer with the given email " + email);
    }

    @Override
    public void updateRecord(String tableName, String updatedValues, String conditionColumn, String conditionValue) {
        // Simulate updating a record in the database
        // (in a real database, you would execute SQL update statements)
        System.out.println("Updating record in " + tableName + " with condition " + conditionColumn + "='" + conditionValue + "': " + updatedValues);
    }
	@Override
	public Business getBusinessAccount() {
		return StubDataBaseRecords.business;
	}

	@Override
	public boolean registerCustomer(Customer object) {
		for (Customer customer: StubDataBaseRecords.customers)
		{
			
		}
		return false;
	}

	@Override
	public List<Table> getAllTables() {
		return StubDataBaseRecords.tables;
	}

	@Override
	public List<Reservation> getReservationsForDate(LocalDate date) {
		return StubDataBaseRecords.reservations.stream().filter(reservation -> reservation.getDate().equals(date)).collect(Collectors.toList());
		
		
	}

}
