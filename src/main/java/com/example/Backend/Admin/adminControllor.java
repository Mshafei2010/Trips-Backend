package com.example.Backend.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/admin")
@CrossOrigin (origins = "http://localhost:4200")
public class adminControllor {

    private final adminService AdminService;

    @Autowired
    public adminControllor (adminService AdminService)
    {
        this.AdminService=AdminService;
    }

    @GetMapping
    public List<admin> getAll(){
        return AdminService.getAll();
    }

    @PostMapping(path = "{name}/{email}/{password}")
    public void registerNewAdmin(@PathVariable("name") String name,
                                 @PathVariable("email") String email,
                                 @PathVariable("password") String password)
    {
        admin Admin =new admin(name,email,password);
        AdminService.addNewAdmin(Admin);
    }

    @DeleteMapping (path= "{id}")
    public void deleteAdmin (@PathVariable("id") Long adminid)
    {
        AdminService.deleteAdmin(adminid);
    }

    @PutMapping (path = "{id}")
    public void updateAdmin (
            @PathVariable("id") Long id,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String email,
            @RequestParam(required = false)String password)
    {
        AdminService.updateAdmin(id,name,email,password);
    }
}
