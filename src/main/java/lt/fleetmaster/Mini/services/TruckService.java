package lt.fleetmaster.Mini.services;

import lt.fleetmaster.Mini.DTO.TruckDTO;
import lt.fleetmaster.Mini.domain.Driver;
import lt.fleetmaster.Mini.domain.Trailer;
import lt.fleetmaster.Mini.domain.Truck;
import lt.fleetmaster.Mini.repositories.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TruckService {

    @Autowired
    private TruckRepository truckRepo;

    public Truck getTruckByFleetNumber(int id) {
        return truckRepo.findByFleetIdentificationNumber(id);
    }

    public TruckDTO getTruckDTOByFleetNumber(int id) {
        return new TruckDTO(truckRepo.findByFleetIdentificationNumber(id));
    }

    public void addTrailerToTruck(Trailer trailer, int truckId) {
        Truck truck = getTruckByFleetNumber(truckId);
        truck.setAssignedTrailer(trailer);
    }

    public void addDriverToTruck(Driver driver, int truckId) {
        Truck truck = getTruckByFleetNumber(truckId);
        if (truck.getDrivers().size() < 2) {
            Set<Driver> newSet = truck.getDrivers();
            newSet.add(driver);
            truck.setDrivers(newSet);
        }
    }

    public String saveTruck(TruckDTO truck) {
        truckRepo.save(new Truck(truck.getModel(), truck.getFleetIdentificationNumber()));
        return "Truck created successfully";
    }
}
