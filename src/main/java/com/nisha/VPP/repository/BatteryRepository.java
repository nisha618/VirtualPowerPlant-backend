package com.nisha.VPP.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nisha.VPP.entity.BatteriesModel;

public interface BatteryRepository extends JpaRepository<BatteriesModel, Integer> {

    @Query(value = "SELECT * FROM battery where postcode between :postcodeFrom and :postcodeTo order by name ASC", nativeQuery = true)
    List<BatteriesModel> batteryListBetweenPostcode(@Param("postcodeFrom") int postcodeFrom,@Param("postcodeTo") int postcodeTo);

    
}
