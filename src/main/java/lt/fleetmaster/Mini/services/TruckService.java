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

    public TruckDTO getTruckById(int id) {
        return new TruckDTO(truckRepo.getReferenceById(id));
    }

    public Truck saveTruck(TruckDTO truck) {
        return truckRepo.save(new Truck(truck.getFleetIdentificationNumber()));
    }
}
