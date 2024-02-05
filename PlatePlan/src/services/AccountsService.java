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
		
		Customer customer = new Customer (firstName, lastName, email, password, new ArrayList<>());
		

		//TODO: Add Customer to database if an error is returned then return null or throw an exception. Duplicates are checked by the 
		//SQL database
		db.insertRecord(SQLTables.ACCOUNTS_TABLE, customer.genSQLValue());
		
		return null;
	}
}


