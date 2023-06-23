package com.testproject.testproject.models.car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "manufacturers")
public class CarManufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;

    @Column (name = "manufacturer_name")
    private String name;

    @OneToMany (mappedBy = "carManufacturer",
            cascade = CascadeType.ALL)
    private List<Car> cars;
}
