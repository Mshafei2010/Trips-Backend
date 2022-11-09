package com.example.Backend.Station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface stationRepositery extends JpaRepository<station, Long> {
    @Query("Select s from station s where s.name =?1")
    Optional<station> findname(String name);
    @Query("Select s from station s where s.name =?1")
    station findname2(String name);

}
