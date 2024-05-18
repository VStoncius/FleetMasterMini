package lt.fleetmaster.Mini.controllers;

import lt.fleetmaster.Mini.DTO.TruckDTO;
import lt.fleetmaster.Mini.services.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trucks")
public class TruckController {

    @Autowired
    private TruckService truckService;

    @GetMapping("/find")
    public ResponseEntity<TruckDTO> getTruckById(@RequestParam int id) {
        return new ResponseEntity<TruckDTO>(truckService.getTruckById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TruckDTO> createTruck(@RequestBody TruckDTO truck) {
        return new ResponseEntity<TruckDTO>(new TruckDTO(truckService.saveTruck(truck)), HttpStatus.CREATED);
    }
}
