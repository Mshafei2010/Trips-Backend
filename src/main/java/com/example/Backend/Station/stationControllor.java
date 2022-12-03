package com.example.Backend.Station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/station")
@CrossOrigin (origins = "*")
public class stationControllor {
    private final stationService StationService;

    @Autowired
    public stationControllor ( stationService StationService)
    {
        this.StationService=StationService;
    }

    @GetMapping
    public List<station> getAll(){
        return StationService.getAll();
    }

    @PostMapping(path= "{name}")
    public void registerNewStation(@PathVariable("name") String name)
    {
        station Station = new station(name);
        StationService.addNewStation(Station);
    }

    @DeleteMapping (path= "{id}")
    public void deleteStation (@PathVariable("id") Long stationid)
    {
        StationService.deleteStation(stationid);
    }

    @PutMapping (path = "{id}")
    public void updateStation (
            @PathVariable("id") Long id,
            @RequestParam(required = false)String name)
    {
        StationService.updateStation(id,name);
    }
}
