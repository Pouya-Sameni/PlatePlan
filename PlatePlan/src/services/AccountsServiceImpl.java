package services;
import java.util.ArrayList;

import javax.security.auth.login.AccountNotFoundException;

import database.DataBase;
import database.DataBaseFactory;
import database.DataBaseImpl;
import database.DataBaseStubImpl;
import database.SQLTables;
import dto.Business;
import dto.Customer;
import dto.Reservation;
import service_interfaces.AccountService;

public class AccountsServiceImpl implements AccountService {
    DataBase db;

	public Customer registerAccount(String firstName, String lastName, String email, String password) {
		
		return null;
	}

	@Override
	public Customer customerLogin(String email, String password) {
		
		try {
			Customer customer = db.getCustomerAccount(email);
			if (customer.getPassword().equals(password))
			{
				
				return customer;
			}
			System.out.println ("Incorrect password given: expected " + customer.getPassword() + " but was " + password);
		}catch (Exception e) {
			System.out.println ("Account with email " + email + " does not exist");
		}
		return null;
	}

	@Override
	public Customer getCustomerAccountDetails(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addReservationToAccount(Reservation reservation, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Business businessLogin(String email, String password) {

		Business business = db.getBusinessAccount();
		
		if (business.getEmail().equals(email) && business.getPassword().equals(password))
		{
			return business;
		}
		System.out.println ("Incorrect password given: expected " + business.getPassword() + " but was " + password);

		
		return null;
	}




    @Override
    public Customer getAccountDetails(String email) {
        try {
            return db.getCustomerAccount(email);
        } catch (Exception e) {
            System.out.println("Account with email " + email + " does not exist");
        }
        return null;
    }

    @Override
    public void addReservationToAccount(Reservation reservation, String email) {
        try {
            Customer customer = db.getCustomerAccount(email);
            customer.addReservation(reservation);
            db.updateRecord(SQLTables.ACCOUNTS_TABLE, customer.genSQLValue(), "email", email);
        } catch (Exception e) {
            System.out.println("Error adding reservation to account: " + e.getMessage());
        }
    }
}