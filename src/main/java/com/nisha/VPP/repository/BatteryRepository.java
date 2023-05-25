package com.nisha.VPP.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nisha.VPP.entity.BatteriesModel;

public interface BatteryRepository extends JpaRepository<BatteriesModel, Integer> {

    @Query(value = "SELECT * FROM battery order by id", nativeQuery = true)
    List<BatteriesModel> batteryList();
    
}
