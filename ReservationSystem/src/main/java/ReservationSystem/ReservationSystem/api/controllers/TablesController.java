package ReservationSystem.ReservationSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ReservationSystem.ReservationSystem.business.abstracts.TablesService;
import ReservationSystem.ReservationSystem.core.utilities.DataResults;
import ReservationSystem.ReservationSystem.core.utilities.Result;
import ReservationSystem.ReservationSystem.entity.concretes.Tables;

@Component
@RestController

@RequestMapping("/api/tables")
@CrossOrigin
public class TablesController {
    

	@Autowired	
	private TablesService tableService;
	
	public TablesController(TablesService tableService) {
		super();
		this.tableService = tableService;
	}

	@GetMapping("/getall")
	public DataResults<List<Tables>> getAll() {
		return this.tableService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Tables tables) {
		return this.tableService.add(tables);

	}

	@PostMapping("/delete")
	public Result delete(int table_id) {
		return this.tableService.delete(table_id);

	}

	@PostMapping("/update")
	public Result update(int table_id, @RequestBody Tables tables) {
		return this.tableService.update(table_id, tables);

	}

}
