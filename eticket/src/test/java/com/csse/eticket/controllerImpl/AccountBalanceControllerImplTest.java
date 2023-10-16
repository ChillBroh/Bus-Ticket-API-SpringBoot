package com.csse.eticket.controllerImpl;


import com.csse.eticket.service.PassengerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AccountBalanceControllerImplTest {

    @Mock
    private PassengerService passengerService;

    @InjectMocks
    private AccountBalanceControllerImpl accountBalanceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testDeductAmountSuccess() {
        int passengerId = 1;
        float balanceToDeduct = 50.0f;
        float remainingBalance = 30.0f;

        when(passengerService.deductAmount(passengerId, balanceToDeduct)).thenReturn(remainingBalance);

        ResponseEntity<?> responseEntity = accountBalanceController.deductAmount(passengerId, balanceToDeduct);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(remainingBalance, responseEntity.getBody());
        verify(passengerService, times(1)).deductAmount(passengerId, balanceToDeduct);
    }

    @Test
    void testDeductAmountException() {
        int passengerId = 1;
        float balanceToDeduct = 50.0f;

        when(passengerService.deductAmount(passengerId, balanceToDeduct)).thenThrow(new RuntimeException("Error occurred"));

        ResponseEntity<?> responseEntity = accountBalanceController.deductAmount(passengerId, balanceToDeduct);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        verify(passengerService, times(1)).deductAmount(passengerId, balanceToDeduct);
    }
}
