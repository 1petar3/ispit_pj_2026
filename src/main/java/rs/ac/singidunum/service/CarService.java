package rs.ac.singidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.singidunum.entity.Car;
import rs.ac.singidunum.model.CarModel;
import rs.ac.singidunum.repo.CarRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Car createCar(CarModel model) {
        Car car = new Car();
        car.setCarId(null);
        car.setUuid(UUID.randomUUID().toString());
        car.setMake(model.getMake());
        car.setModel(model.getModel());
        car.setYear(model.getYear());
        car.setMileageKm(model.getMileageKm());
        car.setFuelType(model.getFuelType());
        car.setTransmission(model.getTransmission());
        car.setEngine(model.getEngine());
        car.setCreatedAt(LocalDateTime.now());
        car.setUpdatedAt(null);
        car.setDeletedAt(null);

        return carRepository.save(car);
    }

    public Car updateCar(Integer id, CarModel model) {
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