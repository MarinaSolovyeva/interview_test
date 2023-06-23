package com.testproject.testproject.repository;

import com.testproject.testproject.models.car.CarManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarManufacturerRepository extends JpaRepository <CarManufacturer, Long> {
}
