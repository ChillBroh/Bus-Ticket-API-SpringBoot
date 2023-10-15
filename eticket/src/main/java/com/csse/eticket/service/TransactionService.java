package com.csse.eticket.service;


import com.csse.eticket.dao.TransactionDao;
import com.csse.eticket.model.Transaction;

public interface TransactionService {

    TransactionDao AddTransaction(float amount);
}
