package rs.ac.singidunum.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.entity.Seller;

import java.util.List;
import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

    List<Seller> findAllByDeletedAtIsNull();

    Optional<Seller> findBySellerIdAndDeletedAtIsNull(Integer sellerId);
}