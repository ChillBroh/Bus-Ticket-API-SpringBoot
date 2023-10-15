package com.csse.eticket.controller;

import com.csse.eticket.dao.TopUpAccDao;
import com.csse.eticket.dao.TopUpDao;
import com.csse.eticket.model.topup.TopUpAcc;
import com.csse.eticket.model.users.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/topup")
public interface TopUpController {
    @PostMapping
    ResponseEntity<?> createTopUpAcc(@RequestBody(required = true) TopUpAccDao topUpAccDao);

    @GetMapping
    ResponseEntity<?> getTopUpAccountsByUser();

    @PostMapping(path = "/transaction")
    ResponseEntity<?> transactMoney(@RequestBody(required = true) TopUpDao topUpDao);

    @PutMapping("/deduct/{id}/{balance}")
    ResponseEntity<?> deductAmount(@PathVariable Integer id, @PathVariable float balance);
}
