package org.example.app;

import org.example.app.entity.Vehicle;
import org.example.app.interfaces.Presenter;
import org.example.app.interfaces.VehicleRegisterLoadAPI;
import org.example.app.interfaces.VehicleRegisterPersistenceStorage;
import org.example.app.interfaces.VehicleRegisterSaveAPI;
import org.example.app.parser.VehicleParser;
import org.example.app.validator.VehicleValidator;


public class VehicleRegister implements VehicleRegisterSaveAPI, VehicleRegisterLoadAPI {

    private Presenter display;
    private VehicleRegisterPersistenceStorage persistenceStorage;
    private VehicleValidator vehicleValidator = new VehicleValidator();
    private VehicleParser vehicleParser = new VehicleParser();

    public VehicleRegister(Presenter display, VehicleRegisterPersistenceStorage persistenceStorage) {
        this.display = display;
        this.persistenceStorage = persistenceStorage;
    }

    @Override
    public void saveVehicle(String vehicle) {
        vehicleValidator.validateString(vehicle);
        Vehicle newVehicle = vehicleParser.StringToEntity(vehicle);
        persistenceStorage.saveVehicle(newVehicle);
        display.DisplaySuccess();
    }

    @Override
    public void loadVehicle(String r) {
        String registrationNumber = vehicleParser.JsonToRegistrationNumber(r);
        Vehicle vehicle =  persistenceStorage.getVehicle(registrationNumber);
        vehicleValidator.validateEntity(vehicle);
        String vehicleJson = vehicleParser.EntityToString(vehicle);
        display.DisplayVehicle(vehicleJson);
    }

}
