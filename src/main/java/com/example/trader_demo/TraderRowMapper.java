package com.example.trader_demo;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TraderRowMapper implements RowMapper<Trader> {


    @Override
    public Trader mapRow(ResultSet rs, int rowNum) throws SQLException {
        Trader trader1 = new Trader();
        trader1.setT_id(rs.getInt("t_id"));
        trader1.setName(rs.getString("name"));
        trader1.setEmail(rs.getString("email"));
        trader1.setBalance(rs.getDouble("balance"));
        trader1.setCreatedAt(rs.getString("createdAt"));
        trader1.setUpdatedAt(rs.getString("updatedAt"));

        return trader1;
    }
}
