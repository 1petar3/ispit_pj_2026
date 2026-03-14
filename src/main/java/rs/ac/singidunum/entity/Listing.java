package rs.ac.singidunum.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "listing")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "listing_id")
    private Integer listingId;

    @Column(nullable = false)
    private String uuid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "price_eur", nullable = false)
    private Integer priceEur;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private Boolean sold;

    @Column(name = "published_at", nullable = false)
    private LocalDateTime publishedAt;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}