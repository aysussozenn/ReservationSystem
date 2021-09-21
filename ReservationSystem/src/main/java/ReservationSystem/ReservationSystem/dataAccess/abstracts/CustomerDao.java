package ReservationSystem.ReservationSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ReservationSystem.ReservationSystem.entity.concretes.Customers;
import ReservationSystem.ReservationSystem.entity.dtos.CustomersWithReservationsDto;

public interface CustomerDao extends JpaRepository<Customers, Integer> {
	
	@Query("Select new ReservationSystem.ReservationSystem.entity.dtos.CustomersWithReservationsDto"
			+ "(r.id, c.customer_id, c.customer_name, c.customer_surname, r.table_id, r.reservation_Date, r.res_starting_Time, r.res_ending_Time, r.reserved)"
			+ " From Customers c Inner Join c.reservations r where r.reserved='true'")
	List<CustomersWithReservationsDto> getCustomersWithReservations();
	
	
	

}
