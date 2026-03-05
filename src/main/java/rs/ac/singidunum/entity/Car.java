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
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer carId;


    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column(name = "mileage_km", nullable = false)
    private Integer mileageKm;

    @Column(name = "fuel_type", nullable = false)
    private String fuelType;

    @Column(nullable = false)
    private String transmission;

    private String engine;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

}