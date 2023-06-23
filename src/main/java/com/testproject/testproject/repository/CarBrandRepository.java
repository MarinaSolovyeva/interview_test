package com.testproject.testproject.repository;

import com.testproject.testproject.models.car.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBrandRepository extends JpaRepository <CarBrand, Long> {
}
