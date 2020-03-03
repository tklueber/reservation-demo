package ch.baloise.klueber.reservationdemo.web.service;

import ch.baloise.klueber.reservationdemo.business.domain.RoomReservation;
import ch.baloise.klueber.reservationdemo.business.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ReservationServiceController {

    @Autowired
    ReservationService reservationService;

    @RequestMapping(method = RequestMethod.GET, value = "/reservations/{date}")
    public List<RoomReservation> getAllReservationForDate(@PathVariable(value = "date") String dateString) {
        return reservationService.getRoomReservationsForDate(dateString);
    }

}
