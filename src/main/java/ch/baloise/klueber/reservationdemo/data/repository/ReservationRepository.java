package ch.baloise.klueber.reservationdemo.data.repository;

import ch.baloise.klueber.reservationdemo.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
     List<Reservation> findByDate(Date date);
}

