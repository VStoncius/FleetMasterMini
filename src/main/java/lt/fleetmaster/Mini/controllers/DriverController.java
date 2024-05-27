package lt.fleetmaster.Mini.controllers;

import lt.fleetmaster.Mini.DTO.DriverDTO;
import lt.fleetmaster.Mini.DTO.TruckDTO;
import lt.fleetmaster.Mini.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    //    annotation for testing purposes
    @CrossOrigin
    @GetMapping("/find")
    public ResponseEntity<DriverDTO> getDriverById(@RequestBody String identification) {
        return new ResponseEntity<DriverDTO>(driverService.getDriverById(identification), HttpStatus.OK);
    }

    //    annotation for testing purposes
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<String> createDriver(@RequestBody DriverDTO driver) {
        return new ResponseEntity(driverService.saveDriver(driver), HttpStatus.CREATED);
    }

    //    annotation for testing purposes
    @CrossOrigin
    @PostMapping("/update")
    public ResponseEntity<String> updateDriver(@RequestBody DriverDTO driver) {
        return new ResponseEntity<>(driverService.updateDriver(driver), HttpStatus.OK);
    }

    //    annotation for testing purposes
    @CrossOrigin
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDriver(@RequestBody String driverIdentification) {
        return new ResponseEntity<>(driverService.deleteDriver(driverIdentification), HttpStatus.NO_CONTENT);
    }
}
