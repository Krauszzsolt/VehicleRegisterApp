package org.example.app.parser;

import org.example.app.entity.Vehicle;
import org.json.JSONException;
import org.json.JSONObject;
public class VehicleParser {

    public String EntityToString(Vehicle v) {
        JSONObject vehicle = new JSONObject();
        try {
            vehicle.put("model", v.model);
            vehicle.put("registrationNumber", v.registrationNumber);
            vehicle.put("make", v.make);
            vehicle.put("numberOfSeats", v.numberOfSeats);
            vehicle.put("vehicleType",v.vehicleType);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return vehicle.toString();
    }

    public Vehicle StringToEntity(String v) {
        JSONObject vehicle;
        String model;
        String registrationNumber;
        String make;
        Integer numberOfSeats;
        String vehicleType;
        try {
            vehicle = new JSONObject(v);
            model = vehicle.getString("model");
            registrationNumber = vehicle.getString("registrationNumber");
            make = vehicle.getString("make");
            numberOfSeats = vehicle.getInt("numberOfSeats");
            vehicleType = vehicle.getString("vehicleType");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return new Vehicle(model, registrationNumber, make, numberOfSeats, vehicleType);
    }
}
