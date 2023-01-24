package org.example.app.entity;

public class Vehicle {
    public String registrationNumber;
    public String model;
    public String make;
    public Integer numberOfSeats;
    public String vehicleType;
    public String motorEmissionType;

    public Vehicle(String registrationNumber, String model, String make, Integer numberOfSeats, String vehicleType, String motEmissionType) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.make = make;
        this.numberOfSeats = numberOfSeats;
        this.vehicleType = vehicleType;
        this.motorEmissionType = motEmissionType;
    }

}
