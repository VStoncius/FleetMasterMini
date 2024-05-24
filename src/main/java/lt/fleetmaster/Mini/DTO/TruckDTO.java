package lt.fleetmaster.Mini.DTO;

import lt.fleetmaster.Mini.domain.Trailer;
import lt.fleetmaster.Mini.domain.Truck;
import lt.fleetmaster.Mini.utils.Utils;

import java.util.Set;

import static java.util.Objects.requireNonNullElse;

public class TruckDTO {

    private int truckIdentificationNumber;
    private String model;
    private int assignedTrailerNumber;
    private Set<String> drivers;

    public TruckDTO(int truckIdentificationNumber, String model, int assignedTrailerNumber, Set<String> drivers) {
        this.truckIdentificationNumber = truckIdentificationNumber;
        this.model = model;
        this.assignedTrailerNumber = assignedTrailerNumber;
        this.drivers = drivers;
    }

    public TruckDTO(Truck truck) {
        this.truckIdentificationNumber = truck.getTruckIdentificationNumber();
        this.model = truck.getModel();
        this.assignedTrailerNumber = requireNonNullElse(truck.getAssignedTrailer(), new Trailer()).getFleetIdentificationNumber();
        this.drivers = Utils.convertDriverSet(truck.getDrivers());
    }

    public int getTruckIdentificationNumber() {
        return truckIdentificationNumber;
    }

    public void setTruckIdentificationNumber(int truckIdentificationNumber) {
        this.truckIdentificationNumber = truckIdentificationNumber;
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
