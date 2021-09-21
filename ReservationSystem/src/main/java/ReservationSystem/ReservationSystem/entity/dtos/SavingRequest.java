package ReservationSystem.ReservationSystem.entity.dtos;

import ReservationSystem.ReservationSystem.entity.concretes.Customers;
import ReservationSystem.ReservationSystem.entity.concretes.Reservations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavingRequest {
	
	private Customers customers;
	
	private Reservations reservations;

}
