package lt.fleetmaster.Mini.DTO;

import lt.fleetmaster.Mini.domain.Truck;
import lt.fleetmaster.Mini.utils.Utils;

import java.util.Set;

public class TruckDTO {

    private String fleetIdentificationNumber;
    private Integer assignedTrailerNumber;
    private Set<String> drivers;

    public TruckDTO(String fleetIdentificationNumber, Integer assignedTrailerNumber, Set<String> drivers) {
        this.fleetIdentificationNumber = fleetIdentificationNumber;
        this.assignedTrailerNumber = assignedTrailerNumber;
        this.drivers = drivers;
    }

    public TruckDTO(Truck truck) {
        this.fleetIdentificationNumber = truck.getFleetIdentificationNumber();
        this.assignedTrailerNumber = truck.getAssignedTrailer().getFleetIdentificationNumber();
        this.drivers = Utils.convertDriverSet(truck.getDrivers());
    }

    public String getFleetIdentificationNumber() {
        return fleetIdentificationNumber;
    }

    public void setFleetIdentificationNumber(String fleetIdentificationNumber) {
        this.fleetIdentificationNumber = fleetIdentificationNumber;
    }

    public Integer getAssignedTrailerNumber() {
        return assignedTrailerNumber;
    }

    public void setAssignedTrailerNumber(Integer assignedTrailerNumber) {
        this.assignedTrailerNumber = assignedTrailerNumber;
    }

    public Set<String> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<String> drivers) {
        this.drivers = drivers;
    }
}
