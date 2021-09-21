package ReservationSystem.ReservationSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ReservationSystem.ReservationSystem.business.abstracts.TablesService;
import ReservationSystem.ReservationSystem.business.abstracts.TimeSlotsService;
import ReservationSystem.ReservationSystem.core.utilities.DataResults;
import ReservationSystem.ReservationSystem.core.utilities.Result;
import ReservationSystem.ReservationSystem.entity.concretes.Tables;
import ReservationSystem.ReservationSystem.entity.concretes.TimeSlots;

@Component
@RestController
@RequestMapping("/api/timeSlots")
public class TimeSlotsController {
	
	
	private TimeSlotsService timeSlotsService;
    
	@Autowired	
	public TimeSlotsController(TimeSlotsService timeSlotsService) {
		super();
		this.timeSlotsService = timeSlotsService;
	}
	
	@GetMapping("/getByTables")
	public DataResults<TimeSlots> getByTablesId(int table_id) {
		return this.timeSlotsService.getByTablesId(table_id);
	}
	
	@GetMapping("/getall")
	public DataResults<List<TimeSlots>> getAll() {
		return this.timeSlotsService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody TimeSlots timeSlots) {
		return this.timeSlotsService.add(timeSlots);

	}

	@PostMapping("/delete")
	public Result delete(int table_id) {
		return this.timeSlotsService.delete(table_id);

	}

	@PostMapping("/update")
	public Result update(int table_id, @RequestBody TimeSlots timeSlots) {
		return this.timeSlotsService.update(table_id, timeSlots);

	}
}
