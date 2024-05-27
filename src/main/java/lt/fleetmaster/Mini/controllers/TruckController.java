package lt.fleetmaster.Mini.controllers;

import lt.fleetmaster.Mini.DTO.TruckDTO;
import lt.fleetmaster.Mini.services.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/trucks")
public class TruckController {

    @Autowired
    private TruckService truckService;

    //    annotation for testing purposes
    @CrossOrigin
    @GetMapping("/find")
    public ResponseEntity<TruckDTO> getTruckById(@RequestParam int truckIdentificationNumber) {
        return new ResponseEntity<TruckDTO>(truckService.getTruckDTOByFleetNumber(truckIdentificationNumber), HttpStatus.OK);
    }

    //    annotation for testing purposes
    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<Set<TruckDTO>> getAllTrucks() {
        return new ResponseEntity<>(truckService.getAllTrucks(), HttpStatus.OK);
    }

    //    annotation for testing purposes
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<String> createTruck(@RequestBody TruckDTO truck) {
        return new ResponseEntity<>(truckService.saveTruck(truck), HttpStatus.CREATED);
    }

    //    annotation for testing purposes
    @CrossOrigin
    @PostMapping("/update")
    public ResponseEntity<String> updateTruck(@RequestBody TruckDTO truck) {
        return new ResponseEntity<>(truckService.updateTruck(truck), HttpStatus.OK);
    }

    //    annotation for testing purposes
    @CrossOrigin
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTruck(@RequestParam int truckIdentificationNumber) {
        return new ResponseEntity<>(truckService.deleteTruck(truckIdentificationNumber), HttpStatus.NO_CONTENT);
    }
}
