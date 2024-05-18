package lt.fleetmaster.Mini.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Truck {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String fleetIdentificationNumber;

    @OneToOne(mappedBy = "assignedTruck", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = true)
    private Trailer assignedTrailer;

    @OneToMany(mappedBy = "truck", orphanRemoval= false)
    private Set<Driver> drivers;

    public Truck(String fleetIdentificationNumber) {
        this.fleetIdentificationNumber = fleetIdentificationNumber;
    }

    public int getId() {
        return id;
    }

    public String getFleetIdentificationNumber() {
        return fleetIdentificationNumber;
    }

    public void setFleetIdentificationNumber(String fleetIdentificationNumber) {
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
}
