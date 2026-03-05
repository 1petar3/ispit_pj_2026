package rs.ac.singidunum.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository <Car, Integer>
{
    List<Car> findAllByDeletedAtIsNull();
    Optional<Car>findByCarIdAndDeletedAtIsNull(Integer carId);
}
