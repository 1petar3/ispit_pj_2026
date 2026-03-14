package rs.ac.singidunum.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.entity.Listing;

import java.util.List;
import java.util.Optional;

public interface ListingRepository extends JpaRepository<Listing, Integer> {

    List<Listing> findAllByDeletedAtIsNull();

    Optional<Listing> findByListingIdAndDeletedAtIsNull(Integer listingId);

    List<Listing> findAllByDeletedAtIsNullAndActiveTrue();

    List<Listing> findAllByDeletedAtIsNullAndSoldTrue();
}