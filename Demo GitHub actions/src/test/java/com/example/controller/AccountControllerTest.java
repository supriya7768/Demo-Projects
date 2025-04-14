package com.example.controller;

import com.example.model.Account;
import com.example.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @Test
    void createAccount() {
        Account account = new Account(1, "Supriya", 1234, "Pune", 1000);
        ResponseEntity<Account> expectedResult = ResponseEntity.status(HttpStatus.CREATED).body(account);
        when(accountService.createAccount(account)).thenReturn(account);
        ResponseEntity<Account> actualResult = accountController.createAccount(account);
        assertEquals(expectedResult.getBody(), actualResult.getBody());
        assertEquals(HttpStatus.CREATED, actualResult.getStatusCode());
        verify(accountService, times(1)).createAccount(account);
    }

    @Test
    void getAllAccount() {
        List<Account> accounts = Arrays.asList(
                new Account(1, "Supriya", 1234, "Pune", 1000),
                new Account(2, "John", 5678, "Mumbai", 2000)
        );
        ResponseEntity<List<Account>> expectedResult = ResponseEntity.status(HttpStatus.FOUND).body(accounts);
        when(accountService.getAllAccount()).thenReturn(accounts);
        ResponseEntity<List<Account>> actualResult = accountController.getAllAccount();
        assertEquals(expectedResult.getBody(), actualResult.getBody());
        assertEquals(HttpStatus.FOUND, actualResult.getStatusCode());
        verify(accountService, times(1)).getAllAccount();
    }

    @Test
    void updateName() {
        int id = 1;
        String updatedName = "Priya";
        Account updatedAccount = new Account(1, updatedName, 1234, "Pune", 1000);
        ResponseEntity<Account> expectedResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedAccount);
        when(accountService.updateAccountName(id, updatedName)).thenReturn(updatedAccount);
        ResponseEntity<Account> actualResult = accountController.updateName(id, updatedName);
        assertEquals(expectedResult.getBody(), actualResult.getBody());
        assertEquals(HttpStatus.ACCEPTED, actualResult.getStatusCode());
        verify(accountService, times(1)).updateAccountName(id, updatedName);
    }

    @Test
    void deleteAccount() {
        int id = 1;
        String expectedMessage = "Deleted account with id : " + id;
        ResponseEntity<String> expectedResult = ResponseEntity.ok(expectedMessage);
        doNothing().when(accountService).deleteAccount(id);
        ResponseEntity<String> actualResult = accountController.deleteAccount(id);
        assertEquals(expectedResult.getBody(), actualResult.getBody());
        assertEquals(HttpStatus.OK, actualResult.getStatusCode());
        verify(accountService, times(1)).deleteAccount(id);
    }
}
