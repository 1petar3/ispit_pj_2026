package rs.ac.singidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.singidunum.entity.Car;
import rs.ac.singidunum.repo.CarRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getCars() {
        return carRepository.findAllByDeletedAtIsNull();
    }

    public Optional<Car> getCarById(Integer id) {
        return carRepository.findByCarIdAndDeletedAtIsNull(id);
    }

    public Car createCar(Car model) {
        model.setCarId(null);
        model.setCreatedAt(LocalDateTime.now());
        model.setUpdatedAt(null);
        model.setDeletedAt(null);
        return carRepository.save(model);
    }

    public Car updateCar(Integer id, Car model) {
        Car car = carRepository.findByCarIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        car.setMake(model.getMake());
        car.setModel(model.getModel());
        car.setYear(model.getYear());
        car.setMileageKm(model.getMileageKm());
        car.setFuelType(model.getFuelType());
        car.setTransmission(model.getTransmission());
        car.setEngine(model.getEngine());
        car.setUpdatedAt(LocalDateTime.now());

        return carRepository.save(car);
    }

    public void deleteCar(Integer id) {
        Car car = carRepository.findByCarIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        car.setDeletedAt(LocalDateTime.now());
        car.setUpdatedAt(LocalDateTime.now());
        carRepository.save(car);
    }
}