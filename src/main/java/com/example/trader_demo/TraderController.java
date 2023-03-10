package com.example.trader_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/trading/traders")         //Base address

public class TraderController {

    @Autowired
    private TraderServiceImpl trader_ser;

    public TraderController(TraderServiceImpl trader_ser) {
        this.trader_ser = trader_ser;
    }

    //API: POST [trading/traders/register]
    // Insert a record: input (name, email, balance), output (201 | 400)
    @PostMapping("/register")
    public ResponseEntity<?> addTrader(@RequestBody Trader trader){

        //method returns 0 for failure
        int status = trader_ser.insertRecord(trader);

        if(status >= 1)
        {
            return ResponseEntity.status(CREATED).body("");
        }
        else
        {
            return ResponseEntity.status(BAD_REQUEST).body("");
        }
    }

    //API: GET [trading/traders/all]
    // Retrieve all records - output (200 | 404)
    @GetMapping("/all")
    public ResponseEntity<?> getAll()
    {
        try{
            List<Trader> allTraders = trader_ser.fetchAllRecords();
            return ResponseEntity.status(OK).body(allTraders);
        }
        catch(Exception ex)
        {
            return ResponseEntity.status(NOT_FOUND).body("");
        }
    }

    //API: GET [trading/traders?email={email}]
    // Retrieve specific record: input (email - request param) output (200 | 404)
    @GetMapping("")
    public ResponseEntity<?> getOneRow(@RequestParam("email") String email)
    {
        try
        {
            Trader trader = trader_ser.fetchRecord(email);
            return ResponseEntity.status(OK).body(trader);
        }
        catch(Exception ex)
        {
            return ResponseEntity.status(NOT_FOUND).body("");
        }

    }

    //API: PUT [trading/traders]
    // Update record by email - input (email, new name) output (200 | 404)
    @PutMapping("")
    public ResponseEntity<?> updateName(@RequestBody Trader trader)
    {
        int status = trader_ser.updateName(trader);

        if(status == 0)
        {
            return ResponseEntity.status(BAD_REQUEST).body("");
        }
        else
        {
            return ResponseEntity.status(OK).body("");
        }

    }

    //API: PUT [trading/traders/add]
    // Update balance by email - input (email, balance) output (200 | 404)
    @PutMapping("/add")
    public ResponseEntity<?> updateBalance(@RequestBody Trader trader)
    {
        int status = trader_ser.updateBalance(trader);

        if(status == 0)
        {
            return ResponseEntity.status(BAD_REQUEST).body("");
        }
        else
        {
            return ResponseEntity.status(OK).body("");
        }

    }
}
