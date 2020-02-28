package ch.baloise.klueber.reservationdemo.webservice;

import ch.baloise.klueber.reservationdemo.data.entity.Room;
import ch.baloise.klueber.reservationdemo.data.repository.RoomRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomController {
    @Autowired
    private RoomRepository repository;

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    @ApiOperation(value = "find Rooms by roomnumber",
            notes = "Provide a Roomnumber to look up specific room from database",
            response = Room.class)
    List<Room> findAll(@ApiParam(value = "roomnumber is optional", required = false, example = "P1") @RequestParam(required = false) String roomNumber) {
        List<Room> rooms = new ArrayList<>();
        if (null == roomNumber) {
            Iterable<Room> results = this.repository.findAll();
            results.forEach(room -> {
                rooms.add(room);
            });
        } else {
            Room room = this.repository.findByNumber(roomNumber);
            if (null != room) {
                rooms.add(room);
            }
        }
        return rooms;
    }
}
