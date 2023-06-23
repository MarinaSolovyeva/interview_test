package com.testproject.testproject.repository;

import com.testproject.testproject.models.car.TypeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDetailRepository  extends JpaRepository <TypeDetail, Long> {
}
