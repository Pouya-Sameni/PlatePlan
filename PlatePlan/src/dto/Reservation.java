/**
 * 
 */
package dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @NonNull
    private String customerId;
    @NonNull
    private LocalDateTime reservationTime;
    @NonNull
    private int numberOfSeats; // Added field for the number of seats.
}




