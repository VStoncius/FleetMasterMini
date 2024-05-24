package lt.fleetmaster.Mini.services;

import lt.fleetmaster.Mini.DTO.TruckDTO;
import lt.fleetmaster.Mini.domain.Truck;
import lt.fleetmaster.Mini.repositories.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        truckRepo.save(new Truck(truck.getModel(), truck.getTruckIdentificationNumber()));
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
}
