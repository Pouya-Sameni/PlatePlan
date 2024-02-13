package services;
import dto.Customer;
import dto.Reservation;
import dto.TimeSlot;
import service_interfaces.*;
import database.DataBase;
import database.DataBaseFactory;

import java.time.LocalDate;
import java.util.List;

public class ReservationServiceImpl implements ReservationService{
	
	DataBase db;
	
	public ReservationServiceImpl() {
		this.db = DataBaseFactory.getDatabase();
	}


	@Override
	public List<Reservation> getCustomerReservation(String email) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Reservation createCustomerReservation(Customer customer, LocalDate date, TimeSlot slot, int cap) {
		Reservation reservation = new Reservation(customer.getEmail(), date, slot, "", null);
		
		return null;
	}

    // Other service methods would go here
}