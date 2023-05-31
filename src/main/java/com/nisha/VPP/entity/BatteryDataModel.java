package com.nisha.VPP.entity;

import java.util.List;

public class BatteryDataModel {
    private double total;
    private double average;
    public double getTotal() {
        return total;
    }
    public double getAverage() {
        return average;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public void setAverage(double average) {
        this.average = average;
    }
    public void setList(List<BatteriesModel> list) {
        this.list = list;
    }
    public List<BatteriesModel> getList() {
        return list;
    }
    private List<BatteriesModel> list ;

    
    
}
