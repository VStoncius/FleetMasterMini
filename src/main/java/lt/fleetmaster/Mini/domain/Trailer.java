package lt.fleetmaster.Mini.domain;

import jakarta.persistence.*;
import lt.fleetmaster.Mini.DTO.TrailerDTO;

@Entity
public class Trailer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int volume;

    @Column(nullable = false, unique = true)
    private int fleetIdentificationNumber;

    @OneToOne(mappedBy = "assignedTrailer", fetch = FetchType.LAZY)
    private Truck assignedTruck;

    public Trailer(String model, int volume, int fleetIdentificationNumber, Truck assignedTruck) {
        this.model = model;
        this.volume = volume;
        this.fleetIdentificationNumber = fleetIdentificationNumber;
        this.assignedTruck = assignedTruck;
    }

    public Trailer(TrailerDTO trailer) {
        this.model = trailer.getModel();
        this.volume = trailer.getVolume();
        this.fleetIdentificationNumber = trailer.getFleetIdentificationNumber();
        this.assignedTruck = null;
    }

    public Trailer() {
    }

    public int getId() {
        return id;
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

    public Truck getAssignedTruck() {
        return assignedTruck;
    }

    public void setAssignedTruck(Truck assignedTruck) {
        this.assignedTruck = assignedTruck;
    }
}
