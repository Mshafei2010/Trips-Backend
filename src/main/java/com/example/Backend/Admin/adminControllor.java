package com.example.Backend.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/admin")
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

    @PostMapping
    public String registerNewAdmin(@RequestBody admin Admin)
    {
        return AdminService.addNewAdmin(Admin);
    }

    @DeleteMapping (path= "{id}")
    public String deleteAdmin (@PathVariable("id") Long adminid)
    {
        return AdminService.deleteAdmin(adminid);
    }

    @PutMapping (path = "{id}")
    public String updateAdmin (
            @PathVariable("id") Long id,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String email,
            @RequestParam(required = false)String password)
    {
        return AdminService.updateAdmin(id,name,email,password);
    }
}
