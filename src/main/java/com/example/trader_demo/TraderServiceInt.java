package com.example.trader_demo;

import java.sql.SQLException;
import java.util.List;

public interface TraderServiceInt {

    Trader fetchRecord(String email);
    List<Trader> fetchAllRecords();

    int insertRecord(Trader trader) throws SQLException;

    int updateName(Trader trader);

    int updateBalance(Trader trader);

}
