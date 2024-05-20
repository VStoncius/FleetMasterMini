package lt.fleetmaster.Mini.controllers;

import lt.fleetmaster.Mini.DTO.DriverDTO;
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

    @GetMapping("/find")
    public ResponseEntity<DriverDTO> getDriverById(@RequestBody String identification) {
        return new ResponseEntity<DriverDTO>(driverService.getDriverById(identification), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createDriver(@RequestBody DriverDTO driver) {
        return new ResponseEntity(driverService.saveDriver(driver), HttpStatus.CREATED);
    }
}
