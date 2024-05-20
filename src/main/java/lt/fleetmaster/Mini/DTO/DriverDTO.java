package lt.fleetmaster.Mini.DTO;

import lt.fleetmaster.Mini.domain.Driver;

public class DriverDTO {

    private String firstName;
    private String middleName;
    private String lastName;
    private String personalIdentification;
    private int truckIdentificationNumber;

    public DriverDTO(String firstName, String middleName, String lastName, String personalIdentification, int truckIdentificationNumber) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.personalIdentification = personalIdentification;
        this.truckIdentificationNumber = truckIdentificationNumber;
    }

    public DriverDTO(Driver driver) {
        this.firstName = driver.getFirstName();
        this.middleName = driver.getMiddleName();
        this.lastName = driver.getLastName();
        this.personalIdentification = driver.getPersonalIdentification();
        this.truckIdentificationNumber = driver.getTruck().getFleetIdentificationNumber();
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

    public int getTruckIdentificationNumber() {
        return truckIdentificationNumber;
    }

    public void setTruckIdentificationNumber(int truckIdentificationNumber) {
        this.truckIdentificationNumber = truckIdentificationNumber;
    }
}
