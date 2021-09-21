package ReservationSystem.ReservationSystem.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Component;

import ReservationSystem.ReservationSystem.core.utilities.DataResults;
import ReservationSystem.ReservationSystem.core.utilities.Result;
import ReservationSystem.ReservationSystem.entity.concretes.Reservations;

@Component
public interface ReservationServices {
	DataResults<List<Reservations>> getAll();

	Result add(Reservations reservations);

	Result delete(int customer_id);

	Result update(int customer_id, Reservations reservations);
}
