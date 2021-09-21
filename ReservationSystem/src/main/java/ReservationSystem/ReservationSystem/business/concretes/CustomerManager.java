package ReservationSystem.ReservationSystem.business.concretes;

import ReservationSystem.ReservationSystem.core.utilities.Result;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import ReservationSystem.ReservationSystem.business.abstracts.CustomerService;
import ReservationSystem.ReservationSystem.core.utilities.DataResults;
import ReservationSystem.ReservationSystem.core.utilities.ErrorResult;
import ReservationSystem.ReservationSystem.core.utilities.SuccessDataResults;
import ReservationSystem.ReservationSystem.core.utilities.SuccessResult;
import ReservationSystem.ReservationSystem.dataAccess.abstracts.CustomerDao;
import ReservationSystem.ReservationSystem.entity.concretes.Customers;
import ReservationSystem.ReservationSystem.entity.dtos.CustomersWithReservationsDto;
import net.bytebuddy.asm.Advice.This;

@Service
public class CustomerManager implements CustomerService {

	private CustomerDao customerDao;
	
	@Autowired
	public CustomerManager(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}


	@Override
	@Query(value = "SELECT * FROM reservations r WHERE r.reserved = 1", 
	  nativeQuery = true)
	public DataResults<List<Customers>> getAll() {
		
		
		return new SuccessDataResults<List<Customers>>(this.customerDao.findAll(), "Customers listed.");
	}


	@Override
	public Result add(Customers customer) {
		
		this.customerDao.save(customer);
		
		return new SuccessResult("Customer added") ;
	}


	@Override
	public Result delete(int customer_id) {
		if (this.customerDao.findById(customer_id).isPresent()) {
			this.customerDao.deleteById(customer_id);
			return new SuccessResult("Customer deleted");
		}
		
		return new ErrorResult("Customer could not be deleted");
	}


	@Override
	public Result update(int customer_id, Customers customers) {
		if (this.customerDao.findById(customer_id).isPresent()) {
			this.customerDao.findById(customer_id);
			this.customerDao.save(customers);
			return new SuccessResult("Customer updated");
		}
		
		
		return new ErrorResult("Customer could not be founded. Updating process is not successfull");
	}


	@Override
	public DataResults<List<CustomersWithReservationsDto>> getCustomersWithReservations() {

		return new SuccessDataResults<List<CustomersWithReservationsDto>>(this.customerDao.getCustomersWithReservations(), "Customers listed.");
	}




}
