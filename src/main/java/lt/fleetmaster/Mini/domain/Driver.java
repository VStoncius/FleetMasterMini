package lt.fleetmaster.Mini.domain;

import jakarta.persistence.*;

@Entity
public class Driver {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = true)
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String personalIdentification;

    @ManyToOne
    @JoinColumn(name="truck_id")
    private Truck truck;

    public Driver(String firstName, String middleName, String lastName, String personalIdentification, Truck truck) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.personalIdentification = personalIdentification;
        this.truck = truck;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalIdentification() {
        return personalIdentification;
    }

    public void setPersonalIdentification(String personalIdentification) {
        this.personalIdentification = personalIdentification;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }
}
