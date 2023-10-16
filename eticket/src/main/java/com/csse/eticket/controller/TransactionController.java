package com.csse.eticket.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/transaction")
public interface TransactionController {

    @PostMapping("/trans/{amount}")
    ResponseEntity<?> addTransaction(@PathVariable float amount);
}
