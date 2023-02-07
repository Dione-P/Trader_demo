package com.example.trader_demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class TraderServiceImpl implements TraderServiceInt {

    private TraderRepository trader_repo;

    public TraderServiceImpl(TraderRepository trader_repo) {
        this.trader_repo = trader_repo;
    }

    //fetch single record
    @Override
    public Trader fetchRecord(String email) {
        try
        {
            return trader_repo.getSpecificRecord(email);
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }

    //fetch all records
    @Override
    public List<Trader> fetchAllRecords() {
        try
        {
            return trader_repo.getAllTraders();
        }
        catch(Exception ex)
        {
            throw ex;
        }

    }

    //insert new record
    @Override
    public int insertRecord(Trader trader) {
        try
        {
            return trader_repo.insertNewTrader(trader);
        }
        catch(Exception ex)
        {
            throw ex;
        }

    }

    //update name as per email
    @Override
    public int updateName(Trader trader) {
        return trader_repo.updateTraderNameByEmail(trader.getEmail(), trader.getName());
    }

    //update balance as per email
    @Override
    public int updateBalance(Trader trader) {
        return trader_repo.updateBalanceByEmail(trader.getEmail(), trader.getBalance());
    }
}
