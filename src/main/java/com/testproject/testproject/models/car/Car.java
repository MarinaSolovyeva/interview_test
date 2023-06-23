package com.testproject.testproject.models.car;

import com.testproject.testproject.models.driver.Driver;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "car_VIN")
    private String VIN;

    @Column(name = "car_number")
    private String number;

    @ManyToMany (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable (name = "cars_details",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "detail_id"))
    private List<CarDetail> carDetailsList;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer_id")
    private CarManufacturer carManufacturer;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    private CarBrand carBrand;

    @Column(name = "car_year_production")
    private String yearProduction;

    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

}
