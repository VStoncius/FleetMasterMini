package lt.fleetmaster.Mini.services;

import lt.fleetmaster.Mini.DTO.TrailerDTO;
import lt.fleetmaster.Mini.domain.Trailer;
import lt.fleetmaster.Mini.repositories.TrailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrailerService {

    @Autowired
    private TrailerRepository trailerRepo;

    @Autowired
    private TruckService truckService;

    public TrailerDTO getTrailerById(int id) {
        return new TrailerDTO(trailerRepo.getReferenceById(id));
    }

    public String saveTrailer(TrailerDTO trailer) {
        Trailer newTrailer = new Trailer(trailer);
        trailerRepo.save(newTrailer);
        if (trailer.getAssignedTruck() != 0) {
            truckService.addTrailerToTruck(newTrailer, trailer.getAssignedTruck());
        }
        return "Trailer created successfully";
    }

    public TrailerDTO getTrailerByReference(int assignedNumber) {
        return new TrailerDTO(trailerRepo.findByFleetIdentificationNumber(assignedNumber));
    }
}
