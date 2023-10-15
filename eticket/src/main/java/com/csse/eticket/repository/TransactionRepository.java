package com.csse.eticket.repository;

import com.csse.eticket.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
