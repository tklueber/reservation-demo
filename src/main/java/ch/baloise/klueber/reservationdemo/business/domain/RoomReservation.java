package ch.baloise.klueber.reservationdemo.business.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RoomReservation {
    private long roomId;
    private long guestId;
    private String roomName;
    private String roomNumber;
    private String firstName;
    private String lastName;
    private Date date;
}
