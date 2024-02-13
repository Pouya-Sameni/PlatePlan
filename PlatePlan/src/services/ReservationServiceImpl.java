package services;
import dto.Reservation;
import service_interfaces.*;
import database.DataBase;
import database.DataBaseFactory;
import java.util.List;

public class ReservationServiceImpl implements ReservationService{
	
	DataBase db;
	
	public ReservationServiceImpl() {
		this.db = DataBaseFactory.getDatabase();
	}

	@Override
	public Reservation createCustomerReservation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getCustomerReservation(String email) {
		// TODO Auto-generated method stub
		return null;
	}

    // Other service methods would go here
}