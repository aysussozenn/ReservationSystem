package ReservationSystem.ReservationSystem.business.abstracts;

import java.beans.JavaBean;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ReservationSystem.ReservationSystem.core.utilities.DataResults;
import ReservationSystem.ReservationSystem.core.utilities.Result;

import ReservationSystem.ReservationSystem.entity.concretes.Tables;

@Component
public interface TablesService {
	DataResults<List<Tables>> getAll();

	Result add(Tables table);

	Result delete(int table_id);

	Result update(int table_id, Tables tables);

}
