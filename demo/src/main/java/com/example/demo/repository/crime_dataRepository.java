package com.example.demo.repository;

import com.example.demo.model.crime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface crime_dataRepository extends JpaRepository<crime, Long> {
    @Query(value = "SELECT * FROM crime_data WHERE STR_TO_DATE(date_occ, '%m/%d/%Y %H:%i:%s') BETWEEN :dateOccStart AND :dateOccEnd", nativeQuery = true)
    List<crime> findByDateOccBetween(@Param("dateOccStart") String dateOccStart, @Param("dateOccEnd") String dateOccEnd);
}