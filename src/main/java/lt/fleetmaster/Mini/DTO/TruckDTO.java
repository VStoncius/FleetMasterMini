package lt.fleetmaster.Mini.DTO;

import lt.fleetmaster.Mini.domain.Truck;
import lt.fleetmaster.Mini.utils.Utils;

import java.util.Set;

public class TruckDTO {

    private int fleetIdentificationNumber;
    private String model;
    private int assignedTrailerNumber;
    private Set<String> drivers;

    public TruckDTO(int fleetIdentificationNumber, String model, int assignedTrailerNumber, Set<String> drivers) {
        this.fleetIdentificationNumber = fleetIdentificationNumber;
        this.model = model;
        this.assignedTrailerNumber = assignedTrailerNumber;
        this.drivers = drivers;
    }

    public TruckDTO(Truck truck) {
        this.fleetIdentificationNumber = truck.getFleetIdentificationNumber();
        this.model = truck.getModel();
        this.assignedTrailerNumber = truck.getAssignedTrailer().getFleetIdentificationNumber();
        this.drivers = Utils.convertDriverSet(truck.getDrivers());
    }

    public int getFleetIdentificationNumber() {
        return fleetIdentificationNumber;
    }

    public void setFleetIdentificationNumber(int fleetIdentificationNumber) {
        this.fleetIdentificationNumber = fleetIdentificationNumber;
    }

    public int getAssignedTrailerNumber() {
        return assignedTrailerNumber;
    }

    public void setAssignedTrailerNumber(int assignedTrailerNumber) {
        this.assignedTrailerNumber = assignedTrailerNumber;
    }

    public Set<String> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<String> drivers) {
        this.drivers = drivers;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
