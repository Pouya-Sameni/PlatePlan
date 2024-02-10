package dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class Business {
	
	@NonNull @Getter
	@Setter
	private String email;
	
	@NonNull @Getter
	@Setter
	private String password;
	
	
}
