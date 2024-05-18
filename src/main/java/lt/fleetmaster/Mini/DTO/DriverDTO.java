package lt.fleetmaster.Mini.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lt.fleetmaster.Mini.domain.Truck;

public class DriverDTO {

    private String firstName;
    private String middleName;
    private String lastName;
    private String personalIdentification;
    private String truckIdentificationNumber;

    public DriverDTO(String firstName, String middleName, String lastName, String personalIdentification, String truckIdentificationNumber) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.personalIdentification = personalIdentification;
        this.truckIdentificationNumber = truckIdentificationNumber;
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

    public String getTruckIdentificationNumber() {
        return truckIdentificationNumber;
    }

    public void setTruckIdentificationNumber(String truckIdentificationNumber) {
        this.truckIdentificationNumber = truckIdentificationNumber;
    }
}
