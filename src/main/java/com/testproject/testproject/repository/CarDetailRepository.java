package com.testproject.testproject.repository;

import com.testproject.testproject.models.car.CarDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDetailRepository extends JpaRepository<CarDetail, Long> {
}
