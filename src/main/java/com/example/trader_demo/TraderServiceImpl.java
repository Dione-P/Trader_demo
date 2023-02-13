package com.example.trader_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class TraderServiceImpl implements TraderServiceInt {

    @Autowired
    private TraderRepository trader_repo;

    public TraderServiceImpl(TraderRepository trader_repo) {
        this.trader_repo = trader_repo;
    }


    //insert new record
    @Override
    public int insertRecord(Trader trader) {
        //check for valid required fields
        if(!validateEmail(trader.getEmail()) || trader.getName() == null || trader.getBalance() < 0.0)
        {
            return 0;
        }

        try
        {
            return trader_repo.insertNewTrader(trader);
        }
        catch(Exception ex)
        {
            throw ex;
        }

    }


    //fetch single record
    @Override
    public Trader fetchRecord(String email) {

        //check email
        if(!validateEmail(email))
        {
            return null;
        }

        //email doesn't exist
        if(trader_repo.getSpecificRecord(email) == null)
        {
            return null;
        }

        return trader_repo.getSpecificRecord(email);

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


    //update name as per email
    @Override
    public int updateName(Trader trader) {
        //added validation
        //if fields are not valid - required email and name
        // balance is not required - not adding validation, will be ignored if entered
        if(!validateEmail(trader.getEmail()) || trader.getName() == null)
        {
            return 0;
        }

        //email doesn't exist
        if(trader_repo.getSpecificRecord(trader.getEmail()) == null)
        {
            return 0;
        }
        //successful != 0
        return trader_repo.updateTraderNameByEmail(trader.getEmail(), trader.getName());
    }

    //update balance as per email
    @Override
    public int updateBalance(Trader trader) {

        //added validation
        //if fields are not valid - required email
        //if balance is missing or 0, no balance update. Not classing this as an error, Negative balance - error
        // name is not required - not adding validation, will be ignored if entered

        //no email entered
        if(!validateEmail(trader.getEmail()) || trader.getBalance() < 0.0)
        {
            return 0;
        }

        //email doesn't exist
        if(trader_repo.getSpecificRecord(trader.getEmail()) == null)
        {
            return 0;
        }
        //successful != 0
        return trader_repo.updateBalanceByEmail(trader.getEmail(), trader.getBalance());
    }

    public static boolean validateEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern p = Pattern.compile(emailRegex);

        if (email == null)
        {
            return false;
        }
        return p.matcher(email).matches();
        //optional: create custom exception for this - not implemented as of now
    }

}
