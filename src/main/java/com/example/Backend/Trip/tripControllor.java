package com.example.Backend.Trip;

import com.example.Backend.Station.station;
import com.example.Backend.Station.stationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/trip")
@CrossOrigin (origins = "*")
public class tripControllor {

    private final tripService TripService;

    private final stationService StationService;
    @Autowired
    public tripControllor(tripService TripService, stationService StationService)
    {
        this.TripService=TripService;
        this.StationService=StationService;
    }

    @GetMapping
    public List<trip> getAll(){
        return TripService.getAll();
    }

    @PostMapping(path= "{start_date}/{end_date}/{to_Station}/{from_Station}")
    public void addNewTrip(
            @PathVariable("start_date") String start_date,
            @PathVariable("end_date") String end_date,
            @PathVariable("to_Station") String to_Station,
            @PathVariable("from_Station") String from_Station

    ){
        station fromStation = StationService.searchByName(from_Station);
        station toStation = StationService.searchByName(to_Station);
        trip Trip = new trip(start_date,end_date,fromStation,toStation);
        TripService.AddNewTrip(Trip);
    }


    @DeleteMapping (path= "{id}")
    public void deleteAdmin (@PathVariable("id") Long id)
    {
        TripService.deleteTrip(id);
    }


    //this.startDate = startDate;
    //        this.endDate = endDate;
    //        this.fromStation = fromStation;
    //        this.toStation = toStation;
    @PutMapping (path = "{id}")
    public void updateAdmin (
            @PathVariable("id") Long id,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String fromStationName,
            @RequestParam(required = false) String toStationName
    )
    {
        TripService.updateTrip(id,startDate,endDate,fromStationName,toStationName);
    }
}
