package ReservationSystem.ReservationSystem.entity.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomersWithReservationsDto {

	private int id;
	private int customer_id;
	private String customer_name;
	private String customer_surname;
	private int table_id;
	private LocalDate reservation_Date;
	private LocalTime res_starting_Time;
	private LocalTime res_ending_Time;
	private boolean reserved;
	
	

}
