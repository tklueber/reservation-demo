package ch.baloise.klueber.reservationdemo.data.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ROOM")
@ApiModel(description = "details about a room")
@Data
public class Room {
    @Id
    @Column(name = "ROOM_ID")

    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The unique id of a room")
    private long id;
    @Column(name = "NAME")
    @ApiModelProperty(notes = "The room name", example = "Piccadilly")
    private String name;
    @Column(name = "ROOM_NUMBER")
    @ApiModelProperty(notes = "The room number", example = "P3")
    private String number;
    @Column(name = "BED_INFO")
    @ApiModelProperty(notes = "bed infos", example = "2D")
    private String bedInfo;
}
