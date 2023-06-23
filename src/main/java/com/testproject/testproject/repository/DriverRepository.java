package com.testproject.testproject.repository;

import com.testproject.testproject.models.driver.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository <Driver, Long> {
}
