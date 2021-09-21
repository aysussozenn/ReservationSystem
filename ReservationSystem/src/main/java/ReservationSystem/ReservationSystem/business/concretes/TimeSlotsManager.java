package ReservationSystem.ReservationSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ReservationSystem.ReservationSystem.business.abstracts.TimeSlotsService;
import ReservationSystem.ReservationSystem.core.utilities.DataResults;
import ReservationSystem.ReservationSystem.core.utilities.ErrorResult;
import ReservationSystem.ReservationSystem.core.utilities.Result;
import ReservationSystem.ReservationSystem.core.utilities.SuccessDataResults;
import ReservationSystem.ReservationSystem.core.utilities.SuccessResult;
import ReservationSystem.ReservationSystem.dataAccess.abstracts.TimeSlotsDao;
import ReservationSystem.ReservationSystem.entity.concretes.Customers;
import ReservationSystem.ReservationSystem.entity.concretes.Tables;
import ReservationSystem.ReservationSystem.entity.concretes.TimeSlots;
import net.bytebuddy.asm.Advice.This;

@Service
public class TimeSlotsManager implements TimeSlotsService {

	private TimeSlotsDao timeSlotsDao;
	
	@Autowired
	public TimeSlotsManager(TimeSlotsDao timeSlotsDao) {
		super();
		this.timeSlotsDao = timeSlotsDao;
	}


	@Override
	public DataResults<TimeSlots> getByTablesId(int table_id) {
		return new SuccessDataResults<TimeSlots>(this.timeSlotsDao.getByTablesId(table_id), "Success");
	}


	@Override
	public DataResults<List<TimeSlots>> getAll() {
		return new SuccessDataResults<List<TimeSlots>>(this.timeSlotsDao.findAll(), "Time Slots listed.");
	}


	@Override
	public Result add(TimeSlots timeSlots) {
		this.timeSlotsDao.save(timeSlots);
		return new SuccessResult("Time Slot added");
	}


	@Override
	public Result delete(int table_id) {
		if (this.timeSlotsDao.findById(table_id).isPresent()) {
			this.timeSlotsDao.deleteById(table_id);
			return new SuccessResult("Time Slot deleted");
		}
		
		return new ErrorResult("Time Slot could not be deleted");
	}


	@Override
	public Result update(int table_id, TimeSlots timeSlots) {
		if (this.timeSlotsDao.findById(table_id).isPresent()) {
			this.timeSlotsDao.findById(table_id);
			this.timeSlotsDao.save(timeSlots);
			
			return new SuccessResult("Table updated");
		}
		
		
		return new ErrorResult("Table could not be founded. Updating process is not successfull");
	}

}
