package services;

import java.util.ArrayList;
import java.util.UUID;

import dto.Customer;
import misc.SQLTables;



public class AccountsService {
	DataBase db;
	
	
	public AccountsService ()
	{
		this.db =  DataBase.getInstance();
	}

	public Customer registerAccount(String firstName, String lastName, String email, String password) {
		//TODO: Check if the account exists
		
		Customer customer = new Customer (firstName, lastName, email, password);
		customer.setReservations(new ArrayList<>());
		

		//TODO: Add Customer to database
		db.insertRecord(SQLTables.ACCOUNTS_TABLE, customer.genSQLValue());
		
		return null;
	}
}
