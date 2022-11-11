package com.example.Backend.Station;

import com.example.Backend.Trip.trip;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
@Entity
@Table
public class station {
    @Id
    @SequenceGenerator(
            name="station_sequence",
            sequenceName = "station_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "station_sequence"
    )
    @Column(name = "station_id")
    long id;
    String name;
    @JsonIgnore
    @OneToMany(mappedBy = "fromStation" , fetch = FetchType.LAZY)
    private List<trip> startTrip;
    @JsonIgnore
    @OneToMany(mappedBy = "toStation", fetch = FetchType.LAZY)
    private List<trip> toTrips;

    public station(long id, String name, List<trip> startTrip, List<trip> toTrips) {
        this.id = id;
        this.name = name;
        this.startTrip = startTrip;
        this.toTrips = toTrips;
    }

    public station(String name) {
        this.name=name;
    }

    public station() {

    }

    public List<trip> getStartTrip() {
        return startTrip;
    }

    public void setStartTrip(List<trip> startTrip) {
        this.startTrip = startTrip;
    }

    public List<trip> getToTrips() {
        return toTrips;
    }

    public void setToTrips(List<trip> toTrips) {
        this.toTrips = toTrips;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
