package lt.fleetmaster.Mini.services;

import lt.fleetmaster.Mini.DTO.TruckDTO;
import lt.fleetmaster.Mini.domain.Truck;
import lt.fleetmaster.Mini.repositories.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TruckService {

    @Autowired
    private TruckRepository truckRepo;

    @Autowired
    private DriverService driverService;

    @Autowired
    private TrailerService trailerService;

    public Truck getTruckByFleetNumber(int id) {
        return truckRepo.findByTruckIdentificationNumber(id);
    }

    public TruckDTO getTruckDTOByFleetNumber(int id) {
        return new TruckDTO(truckRepo.findByTruckIdentificationNumber(id));
    }

    public String saveTruck(TruckDTO truck) {
        Truck newTruck = new Truck(truck.getModel(), truck.getTruckIdentificationNumber());
        if (truck.getAssignedTrailerNumber() != 0) {
            newTruck.setAssignedTrailer(trailerService.getTrailerByReference(truck.getAssignedTrailerNumber()));
        }
        truckRepo.save(newTruck);

        return "Truck created successfully";
    }

    public String updateTruck(TruckDTO truck) {
        Truck truckToUpdate = truckRepo.findByTruckIdentificationNumber(truck.getTruckIdentificationNumber());
        truckToUpdate.setModel(truck.getModel());
        driverService.replaceDrivers(truckToUpdate, truck.getDrivers());
        trailerService.replaceTrailer(truckToUpdate, truck.getAssignedTrailerNumber());
        truckRepo.saveAndFlush(truckToUpdate);
        return "Truck updated";
    }

    public String deleteTruck(int id) {
        Truck truckToDelete = truckRepo.findByTruckIdentificationNumber(id);
//        This could be removed with better hibernate policy
        truckToDelete.setAssignedTrailer(null);
        truckRepo.delete(truckToDelete);
        return "Deleted";
    }

    public Set<TruckDTO> getAllTrucks() {
        List<Truck> allTrucks = truckRepo.findAll();
        Set<TruckDTO> truckSet = allTrucks.stream().map(truck -> new TruckDTO(truck)).collect(Collectors.toSet());
        return truckSet;
    }
}
