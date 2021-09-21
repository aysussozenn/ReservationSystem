package ReservationSystem.ReservationSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ReservationSystem.ReservationSystem.business.abstracts.CustomerService;
import ReservationSystem.ReservationSystem.core.utilities.DataResults;
import ReservationSystem.ReservationSystem.core.utilities.Result;
import ReservationSystem.ReservationSystem.core.utilities.SuccessDataResults;
import ReservationSystem.ReservationSystem.entity.concretes.Customers;
import ReservationSystem.ReservationSystem.entity.dtos.CustomersWithReservationsDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
	
	
	private CustomerService customerService;
	@Autowired
	public CustomersController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}



	@GetMapping("/getall")
	public DataResults<List<Customers>> getAll(){
		return this.customerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@org.springframework.web.bind.annotation.RequestBody Customers customers) {
		return this.customerService.add(customers);
		
	}
	
	@PostMapping("/delete")
	public Result delete(int customer_id) {
		return this.customerService.delete(customer_id);
		
	}
	
	@PostMapping("/update")
	public Result update(int customer_id,Customers customers) {
		return this.customerService.update(customer_id, customers);
		
	}
	
	@GetMapping("/getCustomersWithReservations")
	public DataResults<List<CustomersWithReservationsDto>> getCustomersWithReservations() {

		return this.customerService.getCustomersWithReservations();
	}
	
 
}
