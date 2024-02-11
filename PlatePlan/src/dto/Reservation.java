/**
 * 
 */
package dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation {

	@NonNull @Getter @Setter
	private String customerId;
	@NonNull @Getter @Setter
	private LocalDateTime reservationTime;
	@NonNull @Getter @Setter
	private String specialNotes;
	@NonNull @Getter @Setter
	private Server server;
	@NonNull @Getter @Setter
	private Table table;

	public Reservation(String customerId, String specialNotes, Server server, Table table) {
		this.customerId = customerId;
		this.specialNotes = specialNotes;
		this.server = server;
		this.table = table;
		this.reservationTime = LocalDateTime.now();
				
	}

}
