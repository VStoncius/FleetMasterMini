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
    private int fleetIdentificationNumber;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "trailer_id", referencedColumnName = "id")
    private Trailer assignedTrailer;

    @OneToMany(mappedBy = "truck")
    private Set<Driver> drivers;

    public Truck(String model, int fleetIdentificationNumber, Trailer assignedTrailer, Set<Driver> drivers) {
        this.model = model;
        this.fleetIdentificationNumber = fleetIdentificationNumber;
        this.assignedTrailer = assignedTrailer;
        this.drivers = drivers;
    }

    public Truck(String model, int fleetIdentificationNumber) {
        this.model = model;
        this.fleetIdentificationNumber = fleetIdentificationNumber;
        this.assignedTrailer = null;
        this.drivers = null;
    }

    public Truck() {
    }

    public int getId() {
        return id;
    }

    public int getFleetIdentificationNumber() {
        return fleetIdentificationNumber;
    }

    public void setFleetIdentificationNumber(int fleetIdentificationNumber) {
        this.fleetIdentificationNumber = fleetIdentificationNumber;
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
