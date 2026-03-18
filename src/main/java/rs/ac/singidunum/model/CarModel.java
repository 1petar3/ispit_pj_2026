package rs.ac.singidunum.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarModel {

    private String make;
    private String model;
    private Integer year;
    private Integer mileageKm;
    private String fuelType;
    private String transmission;
    private String engine;
}