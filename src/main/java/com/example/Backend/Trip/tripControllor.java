package com.example.Backend.Trip;

import com.example.Backend.Station.station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/trip")
public class tripControllor {

    private final tripService TripService;

    @Autowired
    public tripControllor(tripService TripService){ this.TripService=TripService;}

    @GetMapping
    public List<trip> getAll(){
        return TripService.getAll();
    }

    @PostMapping
    public String addNewTrip(@RequestBody trip Trip){
        return TripService.AddNewTrip(Trip);
    }


    @DeleteMapping (path= "{id}")
    public String deleteAdmin (@PathVariable("id") Long tripid)
    {
        return TripService.deleteTrip(tripid);
    }


    //this.startDate = startDate;
    //        this.endDate = endDate;
    //        this.fromStation = fromStation;
    //        this.toStation = toStation;
    @PutMapping (path = "{id}")
    public String updateAdmin (
            @PathVariable("id") Long id,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String fromStationName,
            @RequestParam(required = false) String toStationName
    )
    {
        return TripService.updateTrip(id,startDate,endDate,fromStationName,toStationName);
    }
}
