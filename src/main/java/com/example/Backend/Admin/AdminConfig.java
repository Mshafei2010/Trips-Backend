package com.example.Backend.Admin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.List;

@Configuration
public class AdminConfig {

    /*@Bean
    CommandLineRunner commandLineRunner(adminRepositery repositery){
        return args -> {
            admin admin1 = new admin("Mohamed","mshafei2010@yahoo.com","123");
            admin admin2 = new admin("Catherine","Catherine@yahoo.com","123");
            admin admin3 = new admin("Aliaa","Aliaa@yahoo.com","123");

            repositery.saveAll(List.of(admin1,admin2,admin3));
        };
    }*/
}
