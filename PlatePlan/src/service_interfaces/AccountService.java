package service_interfaces;

import dto.Customer;
import dto.Reservation;

public interface AccountService {
    
    Customer registerAccount(String firstName, String lastName, String email, String password);
    
    Customer login(String email, String password);
    
    Customer getAccountDetails(String email);

    
    
    void addReservationToAccount(Reservation reservation, String email);
}