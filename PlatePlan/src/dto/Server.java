package dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Server {

	private UUID id;
	private String firstName;
	private String lastName;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	 
	// Auto-generates a UUID in case non is given, only first and last name
	public Server(String firstName,String lastName) {
		this.id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;	
	}
}
