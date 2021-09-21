package ReservationSystem.ReservationSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ReservationSystem.ReservationSystem.entity.concretes.*;

public interface TableDao extends JpaRepository<Tables, Integer> {

}
