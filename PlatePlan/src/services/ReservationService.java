package services;
import dto.Reservation;
import database.ReservationDAO;
import java.util.List;

public class ReservationService {
    private ReservationDAO reservationDAO = new ReservationDAO();

    public Reservation createReservation(Reservation reservation) {
        // Validate the reservation here (e.g., check for table availability)

        // If valid, save the reservation
        return reservationDAO.save(reservation);
    }

    // Other service methods would go here
}