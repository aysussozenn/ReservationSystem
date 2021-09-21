package ReservationSystem.ReservationSystem.business.abstracts;

import java.util.List;

import ReservationSystem.ReservationSystem.core.utilities.*;

import ReservationSystem.ReservationSystem.core.utilities.DataResults;
import ReservationSystem.ReservationSystem.entity.concretes.Customers;
import ReservationSystem.ReservationSystem.entity.dtos.CustomersWithReservationsDto;

public interface CustomerService {

	DataResults<List<Customers>> getAll();

	Result add(Customers customer);

	Result delete(int customer_id);

	Result update(int customer_id, Customers customers);
	
	DataResults<List<CustomersWithReservationsDto>> getCustomersWithReservations();
	

}
