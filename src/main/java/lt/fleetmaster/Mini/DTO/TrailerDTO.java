package lt.fleetmaster.Mini.DTO;

import lt.fleetmaster.Mini.domain.Trailer;

public class TrailerDTO {

    private String model;
    private int volume;
    private int fleetIdentificationNumber;
    private int assignedTruck;

    public TrailerDTO(String model, int volume, int fleetIdentificationNumber, int assignedTruck) {
        this.model = model;
        this.volume = volume;
        this.fleetIdentificationNumber = fleetIdentificationNumber;
        this.assignedTruck = assignedTruck;
    }

    public TrailerDTO(Trailer trailer) {
        this.model = trailer.getModel();
        this.volume = trailer.getVolume();
        this.fleetIdentificationNumber = trailer.getFleetIdentificationNumber();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getFleetIdentificationNumber() {
        return fleetIdentificationNumber;
    }

    public void setFleetIdentificationNumber(int fleetIdentificationNumber) {
        this.fleetIdentificationNumber = fleetIdentificationNumber;
    }

    public int getAssignedTruck() {
        return assignedTruck;
    }

    public void setAssignedTruck(int assignedTruck) {
        this.assignedTruck = assignedTruck;
    }
}
