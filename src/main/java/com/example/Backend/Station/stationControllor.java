package com.example.Backend.Station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/station")
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

    @PostMapping
    public String registerNewStation(@RequestBody station Station)
    {
        return StationService.addNewStation(Station);
    }

    @DeleteMapping (path= "{id}")
    public String deleteStation (@PathVariable("id") Long stationid)
    {
        return StationService.deleteStation(stationid);
    }

    @PutMapping (path = "{id}")
    public String updateStation (
            @PathVariable("id") Long id,
            @RequestParam(required = false)String name)
    {
        return StationService.updateStation(id,name);
    }
}
