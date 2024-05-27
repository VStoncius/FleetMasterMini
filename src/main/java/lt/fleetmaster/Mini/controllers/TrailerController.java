package lt.fleetmaster.Mini.controllers;

import lt.fleetmaster.Mini.DTO.TrailerDTO;
import lt.fleetmaster.Mini.services.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/trailers")
public class TrailerController {

    @Autowired
    private TrailerService trailerService;

    //    annotation for testing purposes
    @CrossOrigin
    @GetMapping("/find")
    public ResponseEntity<TrailerDTO> getTrailerById(@RequestParam int id) {
        return new ResponseEntity<TrailerDTO>(trailerService.getTrailerDTOByReference(id), HttpStatus.OK);
    }

    //    annotation for testing purposes
    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<Set<TrailerDTO>> getAllTrailers() {
        return new ResponseEntity<Set<TrailerDTO>>(trailerService.getAllTrailers(), HttpStatus.OK);
    }

    //    annotation for testing purposes
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<String> createTrailer(@RequestBody TrailerDTO trailer) {
        return new ResponseEntity<>(trailerService.saveTrailer(trailer), HttpStatus.CREATED);
    }

    //    annotation for testing purposes
    @CrossOrigin
    @PostMapping("/update")
    public ResponseEntity<String> updateTruck(@RequestBody TrailerDTO trailer) {
        return new ResponseEntity<>(trailerService.updateTrailer(trailer), HttpStatus.OK);
    }

    //    annotation for testing purposes
    @CrossOrigin
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTruck(@RequestParam int trailerIdentificationNumber) {
        return new ResponseEntity<>(trailerService.deleteTrailer(trailerIdentificationNumber), HttpStatus.NO_CONTENT);
    }
}
