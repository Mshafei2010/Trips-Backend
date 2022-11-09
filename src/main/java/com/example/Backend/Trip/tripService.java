package com.example.Backend.Trip;

import com.example.Backend.Station.station;
import com.example.Backend.Station.stationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class tripService {
    public tripRepositery TripRepositery;
    stationService StationService;

    @Autowired
    public tripService(tripRepositery TripRepositery,stationService StationService){
        this.TripRepositery=TripRepositery;
        this.StationService=StationService;
    }

    public List<trip> getAll(){
        return TripRepositery.findAll();
    }

    public String AddNewTrip(trip Trip) {
        StationService.append(Trip,Trip.toStation.getId(),true);
        StationService.append(Trip,Trip.fromStation.getId(),false);
        TripRepositery.save(Trip);
        return "saved successfully";
    }

    public String deleteTrip(Long tripid) {
        boolean exist =TripRepositery.existsById(tripid);
        if(exist) {
            TripRepositery.deleteById(tripid);
            return "Trip Deleted Successfully";
        }
        else
            return "it does not exist";
    }

    @Transactional
    public String updateTrip(Long id, String startDate, String endDate, String fromStationName,String toStationName) {

        trip Trip = TripRepositery.findById(id).orElseThrow(()->new IllegalStateException("Trip with id "+id+"does not exist"));
        boolean flag=false;
        if(startDate != null  && !Objects.equals(Trip.startDate,startDate)){
            Trip.setStartDate(startDate);
            flag=true;
        }
        if(endDate != null &&  !Objects.equals(Trip.endDate,endDate)){
            Trip.setEndDate(endDate);
            flag=true;
        }
        station st = StationService.searchByName(fromStationName);
        if(fromStationName != null && st!=null)
        {
            StationService.append(Trip,st.getId(),false);
            Trip.setFromStation(st);
            flag=true;
        }
        st = StationService.searchByName(toStationName);
        if(toStationName!=null&& st!=null){
            station s=StationService.append(Trip,st.getId(),true);
            Trip.setToStation(s);
            flag=true;
        }
        if(flag)
            return "Updated";
        else
            return "No update happen";
    }
}
