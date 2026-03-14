package rs.ac.singidunum.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ListingModel {

    private Integer sellerId;
    private Integer carId;

    private Integer priceEur;
    private String city;
    private Boolean active;
    private Boolean sold;
    private String description;
}