package lt.fleetmaster.Mini.repositories;

import lt.fleetmaster.Mini.domain.Driver;
import lt.fleetmaster.Mini.domain.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
    public Driver findBypersonalIdentification(String personalIdentification);
}
