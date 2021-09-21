package ReservationSystem.ReservationSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ReservationSystem.ReservationSystem.business.abstracts.TablesService;
import ReservationSystem.ReservationSystem.core.utilities.DataResults;
import ReservationSystem.ReservationSystem.core.utilities.ErrorResult;
import ReservationSystem.ReservationSystem.core.utilities.Result;
import ReservationSystem.ReservationSystem.core.utilities.SuccessDataResults;
import ReservationSystem.ReservationSystem.core.utilities.SuccessResult;
import ReservationSystem.ReservationSystem.dataAccess.abstracts.TableDao;

import ReservationSystem.ReservationSystem.entity.concretes.Tables;

@Service
public class TableManager implements TablesService {

	private TableDao tableDao;

	@Autowired
	public TableManager(TableDao tableDao) {
		super();
		this.tableDao = tableDao;
	}

	@Override
	public DataResults<List<Tables>> getAll() {
		return new SuccessDataResults<List<Tables>>(this.tableDao.findAll(), "Tables listed.");

	}

	@Override
	public Result add(Tables table) {
		
		this.tableDao.save(table);
		return new SuccessResult("Table added");

	}

	@Override
	public Result delete(int table_id) {
		if (this.tableDao.findById(table_id).isPresent()) {
			this.tableDao.deleteById(table_id);
			return new SuccessResult("Table deleted");
		}
		
		return new ErrorResult("Table could not be deleted");
	}

	@Override
	public Result update(int table_id, Tables tables) {
		if (this.tableDao.findById(table_id).isPresent()) {
			this.tableDao.findById(table_id);
			this.tableDao.save(tables);
			
			return new SuccessResult("Table updated");
		}
		
		
		return new ErrorResult("Table could not be founded. Updating process is not successfull");
	}

}
