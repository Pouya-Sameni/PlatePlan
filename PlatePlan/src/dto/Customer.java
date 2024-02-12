package dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class Customer {

    @NonNull
    @Getter
    @Setter
    private String email;

    @NonNull
    @Getter
    @Setter
    private String firstName;

    @NonNull
    @Getter
    @Setter
    private String lastName;

    @NonNull
    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private List<Reservation> reservations;

    public void addReservation(Reservation reservation) {
        if (reservations == null) {
            reservations = new ArrayList<>();
        }
        reservations.add(reservation);
    }

    public String genSQLValue() {
        // Use PreparedStatement to avoid SQL injection vulnerabilities
        return "(" +
               "'" + getEmail() + "'," +
               "'" + getFirstName() + "'," +
               "'" + getLastName() + "'," +
               "'" + getPassword() + "'" +
               ")";
    }
}
