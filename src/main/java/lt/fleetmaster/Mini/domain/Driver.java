package lt.fleetmaster.Mini.domain;

import jakarta.persistence.*;
import lt.fleetmaster.Mini.DTO.DriverDTO;

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;

    @Column(nullable = true)
    private String middleName;

    private String lastName;

    @Column(unique = true)
    private String personalIdentification;

    public Driver(String firstName, String middleName, String lastName, String personalIdentification) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.personalIdentification = personalIdentification;
    }

    public Driver(DriverDTO driver) {
        this.firstName = driver.getFirstName();
        this.middleName = driver.getMiddleName();
        this.lastName = driver.getLastName();
        this.personalIdentification = driver.getPersonalIdentification();
    }

    public Driver() {
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
}
