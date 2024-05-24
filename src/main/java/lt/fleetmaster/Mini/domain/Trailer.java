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

    public Trailer(String model, int volume, int fleetIdentificationNumber) {
        this.model = model;
        this.volume = volume;
        this.fleetIdentificationNumber = fleetIdentificationNumber;
    }

    public Trailer(TrailerDTO trailer) {
        this.model = trailer.getModel();
        this.volume = trailer.getVolume();
        this.fleetIdentificationNumber = trailer.getFleetIdentificationNumber();
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
}
