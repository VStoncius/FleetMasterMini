package lt.fleetmaster.Mini.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false, unique = true)
    private int truckIdentificationNumber;

    @OneToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "trailer_id", referencedColumnName = "fleetIdentificationNumber")
    private Trailer assignedTrailer;

    @OneToMany
    @JoinColumn(name="truckIdentificationNumber")
    private Set<Driver> drivers;

    public Truck(String model, int truckIdentificationNumber, Trailer assignedTrailer, Set<Driver> drivers) {
        this.model = model;
        this.truckIdentificationNumber = truckIdentificationNumber;
        this.assignedTrailer = assignedTrailer;
        this.drivers = drivers;
    }

    public Truck(String model, int truckIdentificationNumber) {
        this.model = model;
        this.truckIdentificationNumber = truckIdentificationNumber;
        this.assignedTrailer = null;
        this.drivers = null;
    }

    public Truck() {
    }

    public int getId() {
        return id;
    }

    public int getTruckIdentificationNumber() {
        return truckIdentificationNumber;
    }

    public void setTruckIdentificationNumber(int truckIdentificationNumber) {
        this.truckIdentificationNumber = truckIdentificationNumber;
    }

    public Trailer getAssignedTrailer() {
        return assignedTrailer;
    }

    public void setAssignedTrailer(Trailer assignedTrailer) {
        this.assignedTrailer = assignedTrailer;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
