package com.nisha.VPP.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import com.nisha.VPP.entity.BatteriesModel;
import com.nisha.VPP.entity.BatteryDataModel;
import com.nisha.VPP.repository.BatteryRepository;

@Service
public class BatteryService {

    @Autowired
    private BatteryRepository batteryRepo;


    public BatteriesModel save(BatteriesModel batteryModel){
        return batteryRepo.save(batteryModel);
        
    }

    @Autowired
    private DataSource dataSource;

          

	public DataSource getDataSource() {
            return dataSource;
        }

    public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

    public BatteriesModel update(BatteriesModel batteryModel,int id){
        BatteriesModel obj = batteryRepo.findById(id).get();
        if(!batteryModel.getName().equalsIgnoreCase(null)){
            obj.setName(batteryModel.getName());
        }
        if(batteryModel.getPostcode() != 0){
            obj.setPostcode(batteryModel.getPostcode());
        }
        if(batteryModel.getCapacity() != 0){
            obj.setCapacity(batteryModel.getCapacity());
        }
        return batteryRepo.save(obj);
        
    }

    public List<BatteriesModel> getBatteryList(){
        List<BatteriesModel> list = batteryRepo.findAll();
        if(list == null){
            list= new ArrayList<BatteriesModel>();
        }
        return list;
        
    }

    public BatteriesModel getBatteryListById(int id){
        return batteryRepo.findById(id).get();
    }

    public List<BatteriesModel> getBatteryListBetweenPostcode(int postcodeFrom,int postcodeTo){
        List<BatteriesModel> list = batteryRepo.batteryListBetweenPostcode(postcodeFrom, postcodeTo);
        if(list == null){
            list= new ArrayList<BatteriesModel>();
        }
        return list;
        
    }

    public void deleteById(int id){
         batteryRepo.deleteById(id);
        
    }

    public BatteryDataModel getAverageAndTotalWithData(int postcodeFrom,int postcodeTo){

        List<BatteriesModel> list = batteryRepo.batteryListBetweenPostcode(postcodeFrom, postcodeTo);
        BatteryDataModel model = getAvgAndTotalWithData(postcodeFrom,postcodeTo);
        model.setList(list);

        return model;
        
    }

    public BatteryDataModel getAverageAndTotalWithData(){
        List<BatteriesModel> list = batteryRepo.findAll();
        BatteryDataModel model = getAvgAndTotalWithData();
        model.setList(list);

        return model;
    }

     public BatteryDataModel getAvgAndTotalWithData(){

        String query = "SELECT sum(capacity) AS total, round(AVG(capacity) :: NUMERIC, 2) AS avg "+  
        "FROM battery ;";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(query, new ResultSetExtractor<BatteryDataModel>() {
			@Override
			public BatteryDataModel extractData(ResultSet rs) throws SQLException, DataAccessException {
                BatteryDataModel model = new BatteryDataModel();
				while (rs.next()) {
                    model.setTotal(rs.getDouble(1));
                    model.setAverage(rs.getDouble(2));
					
			}
            return model;
		}

    });

    }

    public BatteryDataModel getAvgAndTotalWithData(int postcodeFrom,int postcodeTo){

  

        String query = "SELECT sum(capacity) AS total, round(AVG(capacity) :: NUMERIC, 2) AS avg "+  
        "FROM battery where postcode between "+postcodeFrom+" and "+postcodeTo+" ;";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(query, new ResultSetExtractor<BatteryDataModel>() {
			@Override
			public BatteryDataModel extractData(ResultSet rs) throws SQLException, DataAccessException {
                BatteryDataModel model = new BatteryDataModel();
				while (rs.next()) {
                    model.setTotal(rs.getDouble(1));
                    model.setAverage(rs.getDouble(2));
					
			}
            return model;
		}

    });

    }

    
}
