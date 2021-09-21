package ReservationSystem.ReservationSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ReservationSystem.ReservationSystem.business.abstracts.ReservationServices;
import ReservationSystem.ReservationSystem.core.utilities.DataResults;
import ReservationSystem.ReservationSystem.core.utilities.Result;
import ReservationSystem.ReservationSystem.entity.concretes.Reservations;
import ReservationSystem.ReservationSystem.entity.concretes.Tables;

@Component
@RestController
@RequestMapping("/api/reservations")
public class ReservationControllers {
	
	private ReservationServices reservationServices;

	@Autowired
	public ReservationControllers(ReservationServices reservationServices) {
		super();
		this.reservationServices = reservationServices;
	}
	
	@GetMapping("/getall")
	public DataResults<List<Reservations>> getAll() {
		return this.reservationServices.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Reservations reservations) {
		return this.reservationServices.add(reservations);

	}

	@PostMapping("/delete")
	public Result delete(@RequestBody int customer_id) {
		return this.reservationServices.delete(customer_id);

	}

	@PostMapping("/update")
	public Result update(int customer_id, Reservations reservations) {
		return this.reservationServices.update(customer_id, reservations);

	}
	
	

}
