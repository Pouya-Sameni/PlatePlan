package dto;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class Server {

	@NonNull @Getter @Setter
	private String id;
	
	@NonNull @Getter @Setter
	private String firstName;
	
	@NonNull @Getter @Setter
	private String lastName;
	
	@Getter @Setter
	private List<Reservation> reservations;
	 

}
