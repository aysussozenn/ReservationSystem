package ReservationSystem.ReservationSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ReservationSystem.ReservationSystem.entity.concretes.Reservations;

public interface ReservationDao extends JpaRepository<Reservations, Integer> {

}
