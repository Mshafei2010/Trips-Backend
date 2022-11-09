package com.example.Backend.Station;

import com.example.Backend.Trip.trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class stationService {
    public stationRepositery StationRepositery;

    @Autowired
    public stationService(stationRepositery StationRepositery){
        this.StationRepositery=StationRepositery;
    }

    public List<station> getAll(){
        return StationRepositery.findAll();
    }

    public String addNewStation(station Station) {
        Optional<station> found = StationRepositery.findname(Station.getName());
        if (!found.isPresent()) {
            StationRepositery.save(Station);
            return Station.getName() + " Added Successfully";
        }
        else
            return "this Station is already added";
    }

    public station searchByName (String name){
        station found = StationRepositery.findname2(name);
        if (found!=null)
            return found;
        else
            return null;

    }

    public String deleteStation(Long id){
        boolean exist =StationRepositery.existsById(id);
        if(exist) {
            station delStation=StationRepositery.getReferenceById(id);
            StationRepositery.deleteById(id);
            return delStation.getName() + " Deleted";
        }
        else
            return "No admin ID";
    }

    @Transactional
    public String updateStation(Long id,String name) {
        station Station = StationRepositery.findById(id).orElseThrow(()->new IllegalStateException("station with id "+id+"does not exist"));
        boolean flag=false;
        if(name != null && name.length()>0 && !Objects.equals(Station.getName(),name)){
            Station.setName(name);
            flag=true;
        }
        if(flag)
            return "Updated";
        else
            return "No update happen";

    }

    @Transactional
    public station append (trip t , long id,boolean flag){
        station s = StationRepositery.findById(id).orElseThrow(()->new IllegalStateException("station with id "+id+"does not exist"));
        if(flag=true) {
            List<trip> tl = s.getStartTrip();
            tl.add(t);
            s.setStartTrip(tl);
        }
        else {
            List<trip> tl = s.getToTrips();
            tl.add(t);
            s.setToTrips(tl);
        }
        if(s==null)
            return null;
        else
            return s;
    }



}
