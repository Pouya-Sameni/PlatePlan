package dto;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class Business {

	@NonNull
	@Getter
	@Setter
	private String email;

	@NonNull
	@Getter
	@Setter
	private String password;

	@NonNull
	@Getter
	@Setter
	private LocalTime openFrom = LocalTime.of(12, 00);

	@NonNull
	@Getter
	@Setter
	private LocalTime openUntil= LocalTime.of(23, 59);
	
	@NonNull 
	@Getter
	@Setter
	private long reservationSlots = 90;
	
	@Getter
	@Setter
	@NonNull
	private List<TimeSlot> allTimeSlots = calculateTimeSlots();
	

	private List<TimeSlot> calculateTimeSlots ()
	{
		LocalTime time = openFrom;
		List<TimeSlot> allSlots = new ArrayList<TimeSlot>();
		for (int i = 1; i <= Duration.between(openFrom, openUntil).toMinutes() / 90; i ++)
		{
			allSlots.add(new TimeSlot(time, time.plusMinutes(reservationSlots)));
			time = time.plusMinutes(reservationSlots);
		}
		
		System.out.println(allSlots);
		return allSlots;
	}
}
