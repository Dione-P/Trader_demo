package com.example.trader_demo;

import java.util.List;

public interface TraderServiceInt {

    Trader fetchRecord(String email);
    List<Trader> fetchAllRecords();

    int insertRecord(Trader trader);

    int updateName(Trader trader);

    int updateBalance(Trader trader);

}
