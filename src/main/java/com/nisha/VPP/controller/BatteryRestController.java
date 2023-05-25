package com.nisha.VPP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisha.VPP.entity.BatteriesModel;
import com.nisha.VPP.service.BatteryService;

@RestController
@RequestMapping("/vpp/battery")
public class BatteryRestController {

    @Autowired
    private BatteryService batteryService;

    @PostMapping("/save")
    public BatteriesModel save(@RequestBody BatteriesModel model){
        return batteryService.save(model);
    }

    @GetMapping("/get")
    public List<BatteriesModel> get(){
        return batteryService.getBatteryList();
    }

    @PutMapping("/update/{id}")
    public BatteriesModel update(@RequestBody BatteriesModel model,@PathVariable("id") int id){
        return batteryService.update(model,id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") int id){
         batteryService.deleteById(id);
    }
    
}
