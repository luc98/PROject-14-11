package com.example.handlingformsubmission.service;

import com.example.handlingformsubmission.Mappers.AirlinesRowMapper;
import com.example.handlingformsubmission.model.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceApp {

    @Autowired
    JdbcTemplate jdbcTemplate;


    /**
     *
     * @return
     */
    public  List<Airline> getAirlines(){
        String sql="select * from AIRLINES";
        List<Airline> query = jdbcTemplate.query(sql, new AirlinesRowMapper());
        query.forEach(item->System.out.println(item.getAirlineNameShort()));
        return query;
    }


    /**
     *
     * @param shortName
     * @param longName
     * @return
     */
    public Integer getEconomySeatsFromAirlines(String shortName, String longName){
        String query="select * from AIRLINES where AIRLINE=?  and AIRLINE_FULL=? ;";
        List<Airline> airline= jdbcTemplate.query(query,new Object[]{shortName,longName},new AirlinesRowMapper());
        if(!airline.isEmpty()){
            Airline a= airline.get(0);
            return a.getEconomySeat();
        }
        return 0;
    }
    
    public Integer getFirstClassFromAirlines(String shortName, String longName){
        String query="select * from AIRLINES where AIRLINE=?  and AIRLINE_FULL=? ;";
        List<Airline> airline= jdbcTemplate.query(query,new Object[]{shortName,longName},new AirlinesRowMapper());
        if(!airline.isEmpty()){
            Airline a= airline.get(0);
            return a.getFirstClassSeat();
        }
        return 0;
    }
    
}
