package rs.ac.singidunum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Car;
import rs.ac.singidunum.service.CarService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/car")
@CrossOrigin
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    @GetMapping
    public List<Car> getCars() {
        return service.getCars();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getCarById(id));
    }

    @PostMapping
    public Car saveCar(@RequestBody Car model) {
        return service.createCar(model);
    }

    @PutMapping(path = "/{id}")
    public Car updateCar(@PathVariable Integer id, @RequestBody Car model) {
        return service.updateCar(id, model);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable Integer id) {
        service.deleteCar(id);
    }
}