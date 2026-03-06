package rs.ac.singidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.singidunum.entity.Seller;
import rs.ac.singidunum.repo.SellerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;

    public List<Seller> getSellers() {
        return sellerRepository.findAllByDeletedAtIsNull();
    }

    public Optional<Seller> getSellerById(Integer id) {
        return sellerRepository.findBySellerIdAndDeletedAtIsNull(id);
    }

    public Seller createSeller(Seller model) {
        model.setSellerId(null);
        model.setCreatedAt(LocalDateTime.now());
        model.setUpdatedAt(null);
        model.setDeletedAt(null);
        return sellerRepository.save(model);
    }

    public Seller updateSeller(Integer id, Seller model) {
        Seller seller = sellerRepository.findBySellerIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        seller.setFirstName(model.getFirstName());
        seller.setLastName(model.getLastName());
        seller.setEmail(model.getEmail());
        seller.setPhone(model.getPhone());
        seller.setUmcn(model.getUmcn());
        seller.setTaxId(model.getTaxId());
        seller.setUpdatedAt(LocalDateTime.now());

        return sellerRepository.save(seller);
    }

    public void deleteSeller(Integer id) {
        Seller seller = sellerRepository.findBySellerIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        seller.setDeletedAt(LocalDateTime.now());
        seller.setUpdatedAt(LocalDateTime.now());
        sellerRepository.save(seller);
    }
}