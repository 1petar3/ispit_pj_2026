package rs.ac.singidunum.model;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

public class ListingModel{
    private Integer sellerId;
    private Integer carId;

    private Integer priceEur;
    private String city;
    private String status;
    private String description;

    private LocalDateTime publishedAt;
}