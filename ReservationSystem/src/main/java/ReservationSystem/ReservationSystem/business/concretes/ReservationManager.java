package ReservationSystem.ReservationSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import ReservationSystem.ReservationSystem.business.abstracts.ReservationServices;
import ReservationSystem.ReservationSystem.core.utilities.DataResults;
import ReservationSystem.ReservationSystem.core.utilities.ErrorResult;
import ReservationSystem.ReservationSystem.core.utilities.Result;
import ReservationSystem.ReservationSystem.core.utilities.SuccessDataResults;
import ReservationSystem.ReservationSystem.core.utilities.SuccessResult;
import ReservationSystem.ReservationSystem.dataAccess.abstracts.ReservationDao;
import ReservationSystem.ReservationSystem.entity.concretes.Reservations;
import ReservationSystem.ReservationSystem.entity.concretes.Tables;

@Service
public class ReservationManager implements ReservationServices {
	
	private ReservationDao reservationDao;

	@Autowired
	public ReservationManager(ReservationDao reservationDao) {
		super();
		this.reservationDao = reservationDao;
	}

	@Override
	@Query(value = "SELECT * FROM reservations r WHERE r.reserved = true", 
			  nativeQuery = true)
	public DataResults<List<Reservations>> getAll() {
		
		return new SuccessDataResults<List<Reservations>>(this.reservationDao.findAll(), "Reservations listed.");
	}

	@Override
	public Result add(Reservations reservations) {
		
		this.reservationDao.save(reservations);
		return new SuccessResult("Reservation added");
	}

	@Override
	public Result delete(int customer_id) {
		if (this.reservationDao.findById(customer_id).isPresent()) {
			this.reservationDao.deleteById(customer_id);
			return new SuccessResult("Reservation deleted");
		}
		
		return new ErrorResult("Reservation could not be deleted");
	}

	@Override
	public Result update(int customer_id, Reservations reservations) {
		if (this.reservationDao.findById(customer_id).isPresent()) {
			this.reservationDao.findById(customer_id);
			this.reservationDao.save(reservations);
			
			return new SuccessResult("Reservation updated");
		}
		
		
		return new ErrorResult("Reservation could not be founded. Updating process is not successfull");
	}
	
	

}
