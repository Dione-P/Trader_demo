package com.example.trader_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TraderRepository {

    @Autowired
    JdbcTemplate jdbcT;

    public TraderRepository(JdbcTemplate jdbcT) {
        this.jdbcT = jdbcT;
    }

    //insert new record
    public int insertNewTrader(Trader trader) {

        String sql_insTrader = "INSERT INTO traders(name, email, balance, createdAt, updatedAt) VALUES ('"
                + trader.getName() + "', '" + trader.getEmail() + "', " + trader.getBalance() + ", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
       try
       {
           return jdbcT.update(sql_insTrader);
       }
       catch(Exception ex)
       {
           throw ex;
       }
    }

    //Get all records - sorted ascending (traders/trading/all)
    public List<Trader> getAllTraders() {

        String sql_getAll = "SELECT * FROM traders ORDER BY t_id ASC";
        return jdbcT.query(sql_getAll, new TraderRowMapper());
    }

    //Get one record by email
    public Trader getSpecificRecord(String ent_email){
        try
        {
            String sql_specific = "SELECT * FROM traders WHERE email = '" + ent_email + "'";
            return jdbcT.queryForObject(sql_specific, new TraderRowMapper());
        }
        catch(IncorrectResultSizeDataAccessException e)
        {
            return null;
        }
    }

    //update name according to email
    public int updateTraderNameByEmail(String email, String upName) {
        String sql_updtNameByEmail = "UPDATE traders SET name = '" + upName + "' WHERE email = '" + email + "'";
        return jdbcT.update(sql_updtNameByEmail);
    }

    //add to existing balance according to email
    public int updateBalanceByEmail(String email, double upBal) {
        String sql_updtBalByEmail = "UPDATE traders SET balance = balance + " + upBal + ", updatedAt = CURRENT_TIMESTAMP WHERE email = '" + email + "'";
        return jdbcT.update(sql_updtBalByEmail);
    }
}
