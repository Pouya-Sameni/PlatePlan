package dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlot {
	
	@Getter
	@Setter
	@NonNull
	private LocalTime from;
	
	@Getter
	@Setter
	@NonNull
	private LocalTime to;

}
