package com.testproject.testproject.models.driver;
import com.testproject.testproject.models.car.Car;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull(message = "Имя не может быть пустым")
    @Size(min = 2, max = 100, message = "Имя не может быть короче 2 и длиннее 100 символов")
    @Column(name = "driver_name")
    private String name;

    @Column(name = "driver_passport")
    private String passport;

    @Enumerated(EnumType.STRING)
    @Column(name = "driver_category_licence")
    private CategoryLicence categoryLicence;

    @Column(name = "driver_date_birth")
    private LocalDate dateBirth;

    @NotNull(message = "Experience should not be empty")
    @Column(name = "driver_experience")
    private int experience;

    @Column(name = "driver_account_balance")
    private double accountBalance;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;
}
