package com.csse.eticket.controllerImpl;

import com.csse.eticket.controllerImpl.TransactionControllerImpl;
import com.csse.eticket.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

class TransactionControllerImplTest {

    @InjectMocks
    private TransactionControllerImpl transactionController;

    @Mock
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddTransaction() {
        float amount = 100.0f;
        String type = "credit";

        when(transactionService.AddTransaction(amount, type));

        ResponseEntity<?> response = transactionController.addTransaction(amount, type);

        verify(transactionService, times(1)).AddTransaction(amount, type);

        // Assert the HTTP response
        assert response != null;
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody().equals("Transaction Added Successfully");
    }

    @Test
    void testGetAllTransactions() {
        when(transactionService.getAllTransactions());

        ResponseEntity<?> response = transactionController.getAllTransactions();

        verify(transactionService, times(1)).getAllTransactions();

        // Assert the HTTP response
        assert response != null;
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody().equals("List of transactions");
    }
}
