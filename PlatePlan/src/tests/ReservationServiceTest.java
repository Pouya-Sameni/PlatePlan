package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import misc.ServiceUtils;
import misc.StubDataBaseRecords;
import database.DataBaseStubImpl;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import dto.*;
import services.ReservationServiceImpl;
class ReservationServiceTest {
    private ReservationServiceImpl reservationService;
    private DataBaseStubImpl dataBase;

    @BeforeEach
    void setUp() {
        dataBase = DataBaseStubImpl.getInstance();
        reservationService = new ReservationServiceImpl();
    }

    @Test
    void createCustomerReservation_Successful() {
        Customer customer = new Customer("johndoe@example.com","john","doe","password");
        LocalDate date = LocalDate.now();
        TimeSlot slot = new TimeSlot(LocalTime.of(12, 0), LocalTime.of(14, 0));
        int capacity = 4;
        String specialNotes = "Near window";

        Reservation result = reservationService.createCustomerReservation(customer, date, slot, capacity, specialNotes);

        assertNotNull(result);
        assertEquals(customer.getEmail(), result.getCustomerId());
    }

    @Test
    void createCustomerReservation_NoTableAvailable() {
        Customer customer = new Customer("johndoe@example.com","john","doe","password");
        LocalDate date = LocalDate.now();
        TimeSlot slot = new TimeSlot(LocalTime.of(12, 0), LocalTime.of(14, 0));
        int capacity = 100; // Assuming no table can accommodate 100 people
        String specialNotes = "Large group"; 

        Reservation result = reservationService.createCustomerReservation(customer, date, slot, capacity, specialNotes);

        assertNull(result);
    }

    
    @Test
    void getCustomerReservation_ExistingReservations() {
    	 dataBase = DataBaseStubImpl.getInstance();
         reservationService = new ReservationServiceImpl();
         StubDataBaseRecords.reservations.clear(); // clearing any previous reservations

         // setting up a fake reservation
         String customerEmail = "existingemail@example.com";
         Reservation fakeReservation = new Reservation(
             "fakeReservationId",
             customerEmail,
             LocalDate.now(),
             new TimeSlot(LocalTime.of(18, 0), LocalTime.of(20, 0)),
             "Test reservation",
             "table1",
             4
         );
         StubDataBaseRecords.reservations.add(fakeReservation);
    	

         List<Reservation> results = reservationService.getCustomerReservation(customerEmail);

         assertNotNull(results);
         assertFalse(results.isEmpty());
         assertEquals(1, results.size()); 
    }

    @Test
    void getCustomerReservation_NoReservations() {
        String customerEmail = "newemail@example.com";

        List<Reservation> results = reservationService.getCustomerReservation(customerEmail);

        assertTrue(results.isEmpty());
    }
    @Test
    void cancelReservation_ExistingReservation() {
    	
        String reservationId = "1";
        Reservation fakeReservation = new Reservation(
            reservationId,
            "customer@example.com",
            LocalDate.now(),
            new TimeSlot(LocalTime.of(18, 0), LocalTime.of(20, 0)),
            "Test reservation",
            "table1",
            4
        );
        StubDataBaseRecords.reservations.add(fakeReservation);

        // now we cancel this reservation
        boolean result = reservationService.cancelReservation(reservationId);

        assertTrue(result, "The reservation should be successfully cancelled");

        
        Reservation cancelledReservation = StubDataBaseRecords.reservations.stream()
                                               .filter(res -> res.getId().equals(reservationId))
                                               .findFirst()
                                               .orElse(null);
        assertNull(cancelledReservation, "The cancelled reservation should no longer exist in the database");
    }

    @Test
    void cancelReservation_NonExistingReservation() {
        String reservationId = "nonExistingId";

        boolean result = reservationService.cancelReservation(reservationId);

        assertFalse(result);
    }

   
    @Test
    void createCustomerReservation_NonOverlappingTimeSlotsSameDay() {
    	dataBase = DataBaseStubImpl.getInstance();
        reservationService = new ReservationServiceImpl();
        StubDataBaseRecords.reservations.clear(); 
    
    	dataBase = DataBaseStubImpl.getInstance();
        reservationService = new ReservationServiceImpl();
        StubDataBaseRecords.reservations.clear(); 
        String customerEmail = "johndoe@example.com";
        Customer customer = new Customer("johndoe@example.com","john","doe","password");
        LocalDate reservationDate = LocalDate.now();
        TimeSlot existingSlot = new TimeSlot(LocalTime.of(12, 0), LocalTime.of(14, 0));

        // adding an existing reservation for the customer
        Reservation existingReservation = new Reservation("resId1", customerEmail, reservationDate, existingSlot, "Existing reservation", "table1", 4);
        StubDataBaseRecords.reservations.add(existingReservation); // Add to the fake database

        // attempt to create a new reservation for the same day but different time slot
        TimeSlot newSlot = new TimeSlot(LocalTime.of(16, 0), LocalTime.of(18, 0));
        String specialNotes = "New reservation";

        Reservation newReservation = reservationService.createCustomerReservation(customer, reservationDate, newSlot, 4, specialNotes);

        assertNotNull(newReservation, "Expected a new reservation to be created as the time slots do not overlap");
    }
    
    @Test
    void createCustomerReservation_AccountNotFoundException() {
    	 dataBase = DataBaseStubImpl.getInstance();
         reservationService = new ReservationServiceImpl();
         StubDataBaseRecords.reservations.clear(); 
    
         String customerEmail = "johndoe@example.com";
         Customer customer = new Customer("johndoe@example.com", "john", "doe", "password");
         
         // ensure no reservations for this customer in StubDataBaseRecords
         StubDataBaseRecords.reservations.removeIf(res -> res.getCustomerId().equals(customerEmail));

         // create a new reservation for a date
         LocalDate reservationDate = LocalDate.now();
         TimeSlot slot = new TimeSlot(LocalTime.of(12, 0), LocalTime.of(14, 0));
         String specialNotes = "Test reservation";
         
         Reservation result = reservationService.createCustomerReservation(customer, reservationDate, slot, 4, specialNotes);

         assertNotNull(result, "Reservation should be created as there are no existing reservations for this customer");
     }
    

}
