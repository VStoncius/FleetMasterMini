package lt.fleetmaster.Mini.services;

import lt.fleetmaster.Mini.DTO.TrailerDTO;
import lt.fleetmaster.Mini.domain.Trailer;
import lt.fleetmaster.Mini.domain.Truck;
import lt.fleetmaster.Mini.repositories.TrailerRepository;
import lt.fleetmaster.Mini.repositories.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public TrailerDTO getTrailerDTOByReference(int assignedNumber) {
        return new TrailerDTO(trailerRepo.findByFleetIdentificationNumber(assignedNumber));
    }

    public Trailer getTrailerByReference(int assignedTrailerNumber) {
        return trailerRepo.findByFleetIdentificationNumber(assignedTrailerNumber);
    }

    public Truck replaceTrailer(Truck truckToUpdate, int assignedTrailerNumber) {
        truckToUpdate.setAssignedTrailer(trailerRepo.findByFleetIdentificationNumber(assignedTrailerNumber));
        return truckToUpdate;
    }

    public Set<TrailerDTO> getAllTrailers() {
        List<Trailer> trailers = trailerRepo.findAll();
        return trailers.stream().map(trailer -> new TrailerDTO(trailer)).collect(Collectors.toSet());
    }


    public String deleteTrailer(int trailerIdentificationNumber) {
        trailerRepo.delete(trailerRepo.findByFleetIdentificationNumber(trailerIdentificationNumber));

        return "Deleted";
    }

    public String updateTrailer(TrailerDTO trailer) {
        Trailer trailerToUpdate = trailerRepo.findByFleetIdentificationNumber(trailer.getFleetIdentificationNumber());
        trailerToUpdate.setModel(trailer.getModel());
        trailerToUpdate.setVolume(trailer.getVolume());
        trailerRepo.save(trailerToUpdate);

        return "Trailer updated";
    }
}
