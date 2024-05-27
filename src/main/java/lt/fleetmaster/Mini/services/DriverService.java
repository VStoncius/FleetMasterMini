package lt.fleetmaster.Mini.services;

import lt.fleetmaster.Mini.DTO.DriverDTO;
import lt.fleetmaster.Mini.domain.Driver;
import lt.fleetmaster.Mini.domain.Truck;
import lt.fleetmaster.Mini.repositories.DriverRepository;
import lt.fleetmaster.Mini.repositories.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepo;

    @Autowired
    private TruckRepository truckRepo;

    public Object saveDriver(DriverDTO driver) {
        Driver newDriver = new Driver(driver);
        driverRepo.save(newDriver);
        if (driver.getTruckIdentificationNumber() != 0) {
            addDriverToTruck(newDriver, driver.getTruckIdentificationNumber());
        }
        return "Driver saved successfully";
    }

    public void addDriverToTruck(Driver driver, int truckId) {
        Truck truck = truckRepo.findByTruckIdentificationNumber(truckId);
        if (truck.getDrivers().size() < 2) {
            Set<Driver> newSet = truck.getDrivers();
            newSet.add(driver);
            truck.setDrivers(newSet);
            truckRepo.saveAndFlush(truck);
        }
    }

    public DriverDTO getDriverById(String identification) {
        return new DriverDTO(driverRepo.findBypersonalIdentification(identification));
    }

    public Truck replaceDrivers(Truck truckToUpdate, Set<String> drivers) {
        Set<Driver> newSet = new HashSet<>();
        for (String driver:drivers) {
            newSet.add(driverRepo.findBypersonalIdentification(driver));
            truckToUpdate.setDrivers(newSet);
            }
        return truckToUpdate;
    }

    public String deleteDriver(String driverIdentification) {
        driverRepo.delete(driverRepo.findBypersonalIdentification(driverIdentification));

        return "Deleted";
    }

    public String updateDriver(DriverDTO driver) {
        Driver driverToUpdate = driverRepo.findBypersonalIdentification(driver.getPersonalIdentification());
        driverToUpdate.setFirstName(driver.getFirstName());
        driverToUpdate.setLastName(driver.getLastName());
        driverToUpdate.setMiddleName(driver.getMiddleName());
        driverRepo.saveAndFlush(driverToUpdate);

        return "Driver updated";
    }
}
