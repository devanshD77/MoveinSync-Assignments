package com.example.busbookingsystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BusInfo {
    @Id
    private Long busno;

    private String busname;

    private Integer seats;

    private Integer occupied;

    private String daysofoperation;

    private String source;

    private String destination;

    private String timeTaken;

    public BusInfo(Long bus_No, String bus_Name, Integer no_of_seats, Integer bus_Occupancy, String days_of_Operation, String source, String destination, String time_Taken) {
        busno = bus_No;
        busname = bus_Name;
        seats = no_of_seats;
        occupied = bus_Occupancy;
        daysofoperation = days_of_Operation;
        this.source = source;
        this.destination = destination;
        timeTaken = time_Taken;
    }

    public BusInfo() {}

    public Long getBusno() {
        return busno;
    }

    public void setBusno(Long busno) {
        this.busno = busno;
    }

    public String getBusname() {
        return busname;
    }

    public void setBusname(String busname) {
        this.busname = busname;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getOccupied() {
        return occupied;
    }

    public void setOccupied(Integer occupied) {
        this.occupied = occupied;
    }

    public String getDaysofoperation() {
        return daysofoperation;
    }

    public void setDaysofoperation(String daysofoperation) {
        this.daysofoperation = daysofoperation;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }

    @Override
    public String toString() {
        return "BusInfo{" +
                "Bus_No=" + busno +
                ", Bus_Name='" + busname + '\'' +
                ", No_of_seats=" + seats +
                ", Bus_Occupancy=" + occupied +
                ", Days_of_Operation='" + daysofoperation + '\'' +
                ", Source='" + source + '\'' +
                ", Destination='" + destination + '\'' +
                ", Time_Taken='" + timeTaken + '\'' +
                '}';
    }
}
