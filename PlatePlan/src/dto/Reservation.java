/**
 * 
 */
package dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Reservation {

	@NonNull
	@Getter
	@Setter
	private String customerId;
	
	@NonNull
	@Getter
	@Setter
	private LocalDate date;
	
	@NonNull
	@Getter
	@Setter
	private TimeSlot time;
	
	@NonNull
	@Getter
	@Setter
	private String specialNotes;

	@Getter
	@Setter
	private Server server;
	
	@Getter
	@Setter
	private Table table;

}
