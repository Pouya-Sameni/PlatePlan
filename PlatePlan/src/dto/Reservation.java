/**
 * 
 */
package dto;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation {

	@NonNull
	private String customerId;
	@NonNull
	private LocalDateTime  reservationTime;
	
	private String specialNotes;
	
	private Server server;
	//hi
	private Table table;

	
	



}
