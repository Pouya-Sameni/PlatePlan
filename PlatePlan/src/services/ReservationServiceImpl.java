package services;
import dto.Customer;
import dto.Reservation;
import dto.Server;
import dto.Table;
import dto.TimeSlot;
import misc.ServiceUtils;
import service_interfaces.*;
import database.DataBase;
import database.DataBaseFactory;
import database.SQLTables;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

public class ReservationServiceImpl implements ReservationService{
	
	DataBase db;
	ServiceUtils serviceUtils;
	public ReservationServiceImpl() {
		this.db = DataBaseFactory.getDatabase();
		serviceUtils = ServiceUtils.getInstance();
	}


	@Override
	public List<Reservation> getCustomerReservation(String email) {
		
		return db.getAllReservations().stream().filter(reservation -> reservation.getCustomerId().equals(email)).collect(Collectors.toList());
	}


	@Override
	public Reservation createCustomerReservation(Customer customer, LocalDate date, TimeSlot slot, int cap) {
		
		List<Table> tablesAvailable = serviceUtils.getTablesMatchingResReq(cap);
		
		if (tablesAvailable.isEmpty())
		{
			return null;
		}
		Reservation reservation = new Reservation(UUID.randomUUID().toString(),
				customer.getEmail(), date, slot, "", tablesAvailable.get(0).getId(), cap);
		
		if (customer.getReservations() != null)
		{
			try {
				for (Reservation cusReservation: db.getCustomerReservations(customer.getEmail()) )
				{
					if (date.equals(cusReservation.getDate()))
					{
						return null;
					}
				}
			} catch (AccountNotFoundException e) {
				e.printStackTrace();
			}
		}else {
			customer.setReservations(new ArrayList<String>());
		}
			
		
			
		//TODO: Add to Customer Reservations
		customer.getReservations().add(reservation.getId());
		
		
		
		//TODO: Add to database
		if (db.insertRecord(SQLTables.RESERVATION_TABLE, reservation))
		{
			System.out.println("Reservation successfully submitted " + reservation);
			return reservation;
		}
		
		
		
		
		return null;
	}

    // Other service methods would go here
}