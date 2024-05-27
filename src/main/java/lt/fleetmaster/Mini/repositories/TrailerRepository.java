package lt.fleetmaster.Mini.repositories;

import lt.fleetmaster.Mini.domain.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrailerRepository extends JpaRepository<Trailer, Integer> {
    public Trailer findByFleetIdentificationNumber(int fleetIdentificationNumber);
}
