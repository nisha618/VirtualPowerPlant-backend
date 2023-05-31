package com.nisha.VPP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisha.VPP.entity.BatteriesModel;
import com.nisha.VPP.entity.BatteryDataModel;
import com.nisha.VPP.service.BatteryService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/vpp/battery")
public class BatteryRestController {

    @Autowired
    private BatteryService batteryService;


    @PostMapping("/")
    public BatteriesModel save(@RequestBody BatteriesModel model) {
        return batteryService.save(model);
    }

    @GetMapping("/{id}")
    public BatteriesModel findById(@PathVariable("id") int id) {
        return batteryService.getBatteryListById(id);
    }

    @PutMapping("/{id}")
    public BatteriesModel update(@RequestBody BatteriesModel model, @PathVariable("id") int id) {
        return batteryService.update(model, id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        batteryService.deleteById(id);
    }
    
    @GetMapping("/{postcodeFrom}/{postcodeTo}")
    public BatteryDataModel findTotalAndAverage(@PathVariable("postcodeFrom") int postcodeFrom,@PathVariable("postcodeTo") int postcodeTo) {
        return batteryService.getAverageAndTotalWithData(postcodeFrom, postcodeTo);
    }

    @GetMapping("/")
    public BatteryDataModel findTotalAndAverageWithData() {
        return batteryService.getAverageAndTotalWithData();
    }

}
