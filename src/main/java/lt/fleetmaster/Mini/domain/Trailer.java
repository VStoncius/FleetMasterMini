package lt.fleetmaster.Mini.domain;

import jakarta.persistence.*;

@Entity
public class Trailer {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int volume;

    @Column(nullable = false)
    private Integer fleetIdentificationNumber;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trailer_id")
    private Truck assignedTruck;

    public Trailer(String model, int volume, Integer fleetIdentificationNumber, Truck assignedTruck) {
        this.model = model;
        this.volume = volume;
        this.fleetIdentificationNumber = fleetIdentificationNumber;
        this.assignedTruck = assignedTruck;
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

    public Integer getFleetIdentificationNumber() {
        return fleetIdentificationNumber;
    }

    public void setFleetIdentificationNumber(Integer fleetIdentificationNumber) {
        this.fleetIdentificationNumber = fleetIdentificationNumber;
    }

    public Truck getAssignedTruck() {
        return assignedTruck;
    }

    public void setAssignedTruck(Truck assignedTruck) {
        this.assignedTruck = assignedTruck;
    }
}
