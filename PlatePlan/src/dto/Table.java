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
@NoArgsConstructor
@ToString
public class Table {
	
	@Getter @Setter @NonNull
	private String id;
	
	@Getter @Setter @NonNull
	private int capacity;
	
	
	
}
