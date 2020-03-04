package ch.baloise.klueber.reservationdemo.business.service;

import ch.baloise.klueber.reservationdemo.business.domain.RoomReservation;
import ch.baloise.klueber.reservationdemo.data.entity.Guest;
import ch.baloise.klueber.reservationdemo.data.entity.Reservation;
import ch.baloise.klueber.reservationdemo.data.entity.Room;
import ch.baloise.klueber.reservationdemo.data.repository.GuestRepository;
import ch.baloise.klueber.reservationdemo.data.repository.ReservationRepository;
import ch.baloise.klueber.reservationdemo.data.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReservationService {

    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public ReservationService(GuestRepository guestRepository, ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(String dateString) {
        Date date = createDateFromString(dateString);
        return getRoomReservationsForDate(date);
    }

    public List<RoomReservation> getRoomReservationsForDate(Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();

        rooms.forEach(room -> {
            roomReservationMap.put(room.getId(),
                    RoomReservation.builder()
                        .roomId(room.getId())
                        .roomName(room.getName())
                        .roomNumber(room.getNumber()).build());
        });

        List<Reservation> reservations = reservationRepository.findByDate(new java.sql.Date(date.getTime()));

        if (null != reservations) {
            reservations.forEach(reservation -> {
                Guest guest = guestRepository.findById(reservation.getGuestId());
                if (null != guest) {
                    RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomID());
                    roomReservation.setFirstName(guest.getFirstName());
                    roomReservation.setLastName(guest.getLastName());
                    roomReservation.setGuestId(guest.getId());
                    roomReservation.setDate(date);
                }
            });
        }
        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long roomId : roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(roomId));
        }
        return roomReservations;
    }

    private Date createDateFromString(String dateString) {
        Date date;
        if(null != dateString) {
            try {
                date = DATE_FORMAT.parse(dateString);
            } catch (ParseException e) {
                date = new Date();
            }
        } else {
            date = new Date();
        }
        return date;
    }
}
