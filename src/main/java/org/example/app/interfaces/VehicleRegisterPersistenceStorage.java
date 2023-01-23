package org.example.app.interfaces;

import org.example.app.entity.Vehicle;

public interface VehicleRegisterPersistenceStorage {
    void saveVehicle(Vehicle vehicle);
    Vehicle getVehicle(String registrationNumber);
}
