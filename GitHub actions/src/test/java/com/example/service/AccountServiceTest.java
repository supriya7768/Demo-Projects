package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    void setup() {
        accountService = new AccountService();
        accountService.accountRepository = accountRepository;
        accountService.entityManager = entityManager;
    }

    @Test
    void createAccount_NewAccountNumber() {
        Account account = new Account(0, "Alice", 0, "CityA", 5000);
        when(accountRepository.findByAccountNumber(anyInt())).thenReturn(Collections.emptyList());
        when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> {
            Account savedAccount = invocation.getArgument(0);
            savedAccount.setId(1); // Mock generated ID
            return savedAccount;
        });
        Account createdAccount = accountService.createAccount(account);
        assertNotNull(createdAccount);
        assertEquals(1, createdAccount.getId());
        assertEquals(account.getName(), createdAccount.getName());
        verify(accountRepository, times(1)).findByAccountNumber(anyInt());
        verify(accountRepository, times(1)).save(any(Account.class));
    }

    @Test
    void createAccount_ExistingAccountNumber() {
        Account account = new Account(0, "Alice", 0, "CityA", 5000);
        Account existingAccount = new Account(1, "ExistingUser", 1234, "CityB", 2000);
        when(accountRepository.findByAccountNumber(anyInt())).thenReturn(Collections.singletonList(existingAccount));
        Account createdAccount = accountService.createAccount(account);
        assertNull(createdAccount);
        verify(accountRepository, times(1)).findByAccountNumber(anyInt());
        verify(accountRepository, never()).save(any(Account.class));
    }

    @Test
    void getAllAccount() {
        List<Account> accounts = Arrays.asList(
                new Account(1, "Alice", 1234, "CityA", 5000),
                new Account(2, "Bob", 5678, "CityB", 7000)
        );
        when(accountRepository.findAll()).thenReturn(accounts);
        List<Account> result = accountService.getAllAccount();
        assertEquals(accounts.size(), result.size());
        assertEquals(accounts, result);
        verify(accountRepository, times(1)).findAll();
    }

    @Test
    void updateAccountName_ValidId() {
        int id = 1;
        String updatedName = "UpdatedName";
        Account existingAccount = new Account(id, "OldName", 1234, "CityA", 5000);
        when(accountRepository.findById(id)).thenReturn(Optional.of(existingAccount));
        when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArgument(0));
        Account updatedAccount = accountService.updateAccountName(id, updatedName);
        assertNotNull(updatedAccount);
        assertEquals(updatedName, updatedAccount.getName());
        verify(accountRepository, times(1)).findById(id);
        verify(accountRepository, times(1)).save(existingAccount);
    }

    @Test
    void updateAccountName_InvalidId() {
        int id = 1;
        String updatedName = "UpdatedName";
        when(accountRepository.findById(id)).thenReturn(Optional.empty());
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> accountService.updateAccountName(id, updatedName));
        assertEquals("Account with ID " + id + " not found", exception.getMessage());
        verify(accountRepository, times(1)).findById(id);
        verify(accountRepository, never()).save(any(Account.class));
    }

    @Test
    void deleteAccount_ValidId() {
        int id = 1;
        Account existingAccount = new Account(id, "Alice", 1234, "CityA", 5000);
        when(accountRepository.findById(id)).thenReturn(Optional.of(existingAccount));
        doNothing().when(accountRepository).deleteById(id);
        accountService.deleteAccount(id);
        verify(accountRepository, times(1)).findById(id);
        verify(accountRepository, times(1)).deleteById(id);
    }

    @Test
    void deleteAccount_InvalidId() {
        int id = 1;
        when(accountRepository.findById(id)).thenReturn(Optional.empty());
        accountService.deleteAccount(id);
        verify(accountRepository, times(1)).findById(id);
        verify(accountRepository, never()).deleteById(id);
    }

}
