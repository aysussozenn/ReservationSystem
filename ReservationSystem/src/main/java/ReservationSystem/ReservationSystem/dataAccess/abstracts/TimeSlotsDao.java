package ReservationSystem.ReservationSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ReservationSystem.ReservationSystem.core.utilities.DataResults;
import ReservationSystem.ReservationSystem.core.utilities.Result;
import ReservationSystem.ReservationSystem.entity.concretes.TimeSlots;

public interface TimeSlotsDao extends JpaRepository<TimeSlots, Integer> {

	TimeSlots getByTablesId(int table_id);
	 
}
