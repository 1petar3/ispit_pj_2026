package rs.ac.singidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.singidunum.entity.Car;
import rs.ac.singidunum.entity.Listing;
import rs.ac.singidunum.entity.Seller;
import rs.ac.singidunum.model.ListingModel;
import rs.ac.singidunum.repo.CarRepository;
import rs.ac.singidunum.repo.ListingRepository;
import rs.ac.singidunum.repo.SellerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ListingService {

    private final ListingRepository listingRepository;
    private final SellerRepository sellerRepository;
    private final CarRepository carRepository;

    public List<Listing> getListings() {
        return listingRepository.findAllByDeletedAtIsNull();
    }

    public Optional<Listing> getListingById(Integer id) {
        return listingRepository.findByListingIdAndDeletedAtIsNull(id);
    }

    public Listing createListing(ListingModel model) {
        Seller seller = sellerRepository.findBySellerIdAndDeletedAtIsNull(model.getSellerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Car car = carRepository.findByCarIdAndDeletedAtIsNull(model.getCarId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Listing listing = new Listing();
        listing.setListingId(null);
        listing.setUuid(UUID.randomUUID().toString());

        listing.setSeller(seller);
        listing.setCar(car);
        listing.setPriceEur(model.getPriceEur());
        listing.setCity(model.getCity());
        listing.setStatus(model.getStatus() == null || model.getStatus().isBlank() ? "ACTIVE" : model.getStatus());
        listing.setDescription(model.getDescription());
        listing.setPublishedAt(model.getPublishedAt());

        listing.setSoldAt(null);
        listing.setCreatedAt(LocalDateTime.now());
        listing.setUpdatedAt(null);
        listing.setDeletedAt(null);

        return listingRepository.save(listing);
    }

    public Listing updateListing(Integer id, ListingModel model) {
        Listing listing = listingRepository.findByListingIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Seller seller = sellerRepository.findBySellerIdAndDeletedAtIsNull(model.getSellerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Car car = carRepository.findByCarIdAndDeletedAtIsNull(model.getCarId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        listing.setSeller(seller);
        listing.setCar(car);
        listing.setPriceEur(model.getPriceEur());
        listing.setCity(model.getCity());
        listing.setStatus(model.getStatus() == null || model.getStatus().isBlank() ? listing.getStatus() : model.getStatus());
        listing.setDescription(model.getDescription());
        listing.setPublishedAt(model.getPublishedAt() == null ? listing.getPublishedAt() : model.getPublishedAt());
        listing.setUpdatedAt(LocalDateTime.now());

        return listingRepository.save(listing);
    }

    public Listing sellListing(Integer id) {
        Listing listing = listingRepository.findByListingIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        listing.setStatus("SOLD");
        listing.setSoldAt(LocalDateTime.now());
        listing.setUpdatedAt(LocalDateTime.now());

        return listingRepository.save(listing);
    }

    public void deleteListing(Integer id) {
        Listing listing = listingRepository.findByListingIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        listing.setDeletedAt(LocalDateTime.now());
        listing.setUpdatedAt(LocalDateTime.now());
        listingRepository.save(listing);
    }
}