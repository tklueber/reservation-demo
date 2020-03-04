package ch.baloise.klueber.reservationdemo.data.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "RESERVATION")
@Data
public class Reservation {
    @Id
    @Column(name = "RESERVATION_ID")
    private long id;
    @Column(name = "ROOM_ID")
    private long roomID;
    @Column(name = "GUEST_ID")
    private long guestId;
    @Column(name = "RES_DATE")
    private Date date;
}
