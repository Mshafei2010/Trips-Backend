package com.example.Backend.Trip;

import com.example.Backend.Station.station;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class trip {
    @Id
    @SequenceGenerator(
            name="trip_sequence",
            sequenceName = "trip_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trip_sequence"
    )
    private long id;
    String startDate;
    String endDate;
    @ManyToOne
    @JoinColumn(name = "startStation")
    station fromStation;
    @ManyToOne
    @JoinColumn(name = "endStation")
    station toStation;

    public trip(long id, String startDate, String endDate, station fromStation, station toStation) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fromStation = fromStation;
        this.toStation = toStation;
    }

    public trip() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public station getFromStation() {
        return fromStation;
    }

    public void setFromStation(station fromStation) {
        this.fromStation = fromStation;
    }

    public station getToStation() {
        return toStation;
    }

    public void setToStation(station toStation) {
        this.toStation = toStation;
    }
}
/*
* @Configuration
public class DateTimeConfig extends WebMvcConfigurationSupport {

    @Bean
    @Override
    public FormattingConversionService mvcConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);

        DateTimeFormatterRegistrar dateTimeRegistrar = new DateTimeFormatterRegistrar();
        dateTimeRegistrar.setDateFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        dateTimeRegistrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        dateTimeRegistrar.registerFormatters(conversionService);

        DateFormatterRegistrar dateRegistrar = new DateFormatterRegistrar();
        dateRegistrar.setFormatter(new DateFormatter("dd.MM.yyyy"));
        dateRegistrar.registerFormatters(conversionService);

        return conversionService;
    }
}
* */