package lt.fleetmaster.Mini.controllers;

import lt.fleetmaster.Mini.DTO.TrailerDTO;
import lt.fleetmaster.Mini.services.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trailers")
public class TrailerController {

    @Autowired
    private TrailerService trailerService;

    @GetMapping("/find")
    public ResponseEntity<TrailerDTO> getTrailerById(@RequestParam int id) {
        return new ResponseEntity<TrailerDTO>(trailerService.getTrailerById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTrailer(@RequestBody TrailerDTO trailer) {
        return new ResponseEntity<>(trailerService.saveTrailer(trailer), HttpStatus.CREATED);
    }
}
