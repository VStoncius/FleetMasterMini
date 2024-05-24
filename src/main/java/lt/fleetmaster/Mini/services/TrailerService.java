package lt.fleetmaster.Mini.services;

import lt.fleetmaster.Mini.DTO.TrailerDTO;
import lt.fleetmaster.Mini.domain.Trailer;
import lt.fleetmaster.Mini.domain.Truck;
import lt.fleetmaster.Mini.repositories.TrailerRepository;
import lt.fleetmaster.Mini.repositories.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrailerService {

    @Autowired
    private TrailerRepository trailerRepo;

    @Autowired
    private TruckRepository truckRepo;

    public TrailerDTO getTrailerById(int id) {
        return new TrailerDTO(trailerRepo.getReferenceById(id));
    }

    public String saveTrailer(TrailerDTO trailer) {
        Trailer newTrailer = new Trailer(trailer);
        trailerRepo.save(newTrailer);
        if (trailer.getAssignedTruck() != 0) {
            addTrailerToTruck(newTrailer, trailer.getAssignedTruck());
        }
        return "Trailer created successfully";
    }

    public void addTrailerToTruck(Trailer trailer, int truckId) {
        Truck truck = truckRepo.findByTruckIdentificationNumber(truckId);
        truck.setAssignedTrailer(trailer);
        truckRepo.saveAndFlush(truck);
    }

    public TrailerDTO getTrailerByReference(int assignedNumber) {
        return new TrailerDTO(trailerRepo.findByFleetIdentificationNumber(assignedNumber));
    }

    public Truck replaceTrailer(Truck truckToUpdate, int assignedTrailerNumber) {
        truckToUpdate.setAssignedTrailer(trailerRepo.findByFleetIdentificationNumber(assignedTrailerNumber));
        return truckToUpdate;
    }
}
