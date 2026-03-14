package rs.ac.singidunum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Listing;
import rs.ac.singidunum.model.ListingModel;
import rs.ac.singidunum.service.ListingService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/listing")
@CrossOrigin
@RequiredArgsConstructor
public class ListingController {

    private final ListingService service;

    @GetMapping
    public List<Listing> getListings() {
        return service.getListings();
    }

    @GetMapping(path = "/active")
    public List<Listing> getActiveListings() {
        return service.getActiveListings();
    }

    @GetMapping(path = "/sold")
    public List<Listing> getSoldListings() {
        return service.getSoldListings();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Listing> getListingById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getListingById(id));
    }

    @PostMapping
    public Listing saveListing(@RequestBody ListingModel model) {
        return service.createListing(model);
    }

    @PutMapping(path = "/{id}")
    public Listing updateListing(@PathVariable Integer id, @RequestBody ListingModel model) {
        return service.updateListing(id, model);
    }

    @PutMapping(path = "/{id}/sold")
    public Listing sellListing(@PathVariable Integer id) {
        return service.sellListing(id);
    }

    @PutMapping(path = "/{id}/activate")
    public Listing activateListing(@PathVariable Integer id) {
        return service.activateListing(id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteListing(@PathVariable Integer id) {
        service.deleteListing(id);
    }
}