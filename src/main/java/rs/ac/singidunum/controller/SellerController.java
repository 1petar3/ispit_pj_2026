package rs.ac.singidunum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Seller;
import rs.ac.singidunum.model.SellerModel;
import rs.ac.singidunum.service.SellerService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/seller")
@CrossOrigin
@RequiredArgsConstructor
public class SellerController {

    private final SellerService service;

    @GetMapping
    public List<Seller> getSellers() {
        return service.getSellers();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getSellerById(id));
    }

    @PostMapping
    public Seller saveSeller(@RequestBody SellerModel model) {
        return service.createSeller(model);
    }

    @PutMapping(path = "/{id}")
    public Seller updateSeller(@PathVariable Integer id, @RequestBody SellerModel model) {
        return service.updateSeller(id, model);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSeller(@PathVariable Integer id) {
        service.deleteSeller(id);
    }
}