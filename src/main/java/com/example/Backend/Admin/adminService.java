package com.example.Backend.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class adminService {

    private final adminRepositery AdminRepositery;

    @Autowired
    public adminService(adminRepositery AdminRepositery)
    {
        this.AdminRepositery=AdminRepositery;
    }
    public List<admin> getAll(){
        return AdminRepositery.findAll();
    }

    public String addNewAdmin(admin admin) {
        Optional<admin> found = AdminRepositery.findadminByEmail(admin.getEmail());
        if (!found.isPresent()) {
            AdminRepositery.save(admin);
            return admin.getName() + " Added Successfully";
        }
        else
            return "email is taken";
    }

    public String deleteAdmin(Long id){
        admin delAdmin=AdminRepositery.getReferenceById(id);
        boolean exist =AdminRepositery.existsById(id);
        if(exist) {
            AdminRepositery.deleteById(id);
            return delAdmin.getName() + " Deleted";
        }
        else
            return "No admin ID";
    }

    @Transactional
    public String updateAdmin(Long id,String name, String email,String password) {
        admin Admin = AdminRepositery.findById(id).orElseThrow(()->new IllegalStateException("admin with id "+id+"does not exist"));
        boolean flag=false;
        if(name != null && name.length()>0 && !Objects.equals(Admin.getName(),name)){
            Admin.setName(name);
            flag=true;
        }
        if(email != null && email.length()>0 && !Objects.equals(Admin.getEmail(),email)){
            Admin.setEmail(email);
            flag=true;
        }
        if(password != null && password.length()>0 && !Objects.equals(Admin.getPassword(),password)){
            Admin.setPassword(password);
            flag=true;
        }
        if(flag)
            return "Updated";
        else
            return "No update happen";

    }
}
