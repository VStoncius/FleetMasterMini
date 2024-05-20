package lt.fleetmaster.Mini.services;

import lt.fleetmaster.Mini.DTO.DriverDTO;
import lt.fleetmaster.Mini.domain.Driver;
import lt.fleetmaster.Mini.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepo;

    @Autowired
    private TruckService truckService;


    public Object saveDriver(DriverDTO driver) {
        Driver newDriver = new Driver(driver);
        if (driver.getTruckIdentificationNumber() != 0) {
            truckService.addDriverToTruck(newDriver, driver.getTruckIdentificationNumber());
        }
        driverRepo.save(newDriver);
        return "Driver saved successfully";
    }

    public DriverDTO getDriverById(String identification) {
        return new DriverDTO(driverRepo.findBypersonalIdentification(identification));
    }
}
