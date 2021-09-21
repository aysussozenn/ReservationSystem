package ReservationSystem.ReservationSystem.business.abstracts;

import java.util.List;

import ReservationSystem.ReservationSystem.core.utilities.DataResults;
import ReservationSystem.ReservationSystem.core.utilities.Result;
import ReservationSystem.ReservationSystem.dataAccess.abstracts.TimeSlotsDao;
import ReservationSystem.ReservationSystem.entity.concretes.Tables;
import ReservationSystem.ReservationSystem.entity.concretes.TimeSlots;

public interface TimeSlotsService {
   DataResults<TimeSlots> getByTablesId(int table_id);
	DataResults<List<TimeSlots>> getAll();

	Result add(TimeSlots table);

	Result delete(int id);

	Result update(int id, TimeSlots timeSlots);
}
