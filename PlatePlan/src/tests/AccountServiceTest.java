package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import database.DataBase;
import database.DataBaseFactory;
import dto.Customer;
import service_interfaces.AccountService;
import service_interfaces.ReservationService;
import services.AccountsServiceImpl;
import services.ReservationServiceImpl;

class AccountServiceTest {
	AccountService accountService;
	ReservationService reservationService;
	DataBase db;
	
	@BeforeEach
	void setUp() throws Exception {
		accountService = new AccountsServiceImpl();
		reservationService = new ReservationServiceImpl();
		db = DataBaseFactory.getDatabase();
		
	}

	@Test
	void testLoginSucess() {
		Customer customer = accountService.customerLogin("john", "password");
		
		assertNotNull(customer);
		assertEquals(customer.getEmail(), "john");
		assertEquals(customer.getFirstName(), "john");	
	}
	
	@Test
	void testLoginFail() {
		Customer customer = accountService.customerLogin("pouya", "password");
		
		assertNull(customer);
	}
	
	@Test
	void testLoginFail2() {
		Customer customer = accountService.customerLogin("john", "wrongPass");
		
		assertNull(customer);
	}

}
