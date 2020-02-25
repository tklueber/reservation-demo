package ch.baloise.klueber.reservationdemo.data.repository;

import ch.baloise.klueber.reservationdemo.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Long> {
    Guest findById(long guestId);
}
