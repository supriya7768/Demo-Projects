package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    EntityManager entityManager;

    private int generateUnique4DigitAccountNumber() {
        Random random = new Random();
        return 1000 + random.nextInt(9000); // Generate a random 4-digit number between 1000 and 9999
    }

    public Account createAccount(Account account){
        int accountNumber = generateUnique4DigitAccountNumber();
        List<Account> existingAccount = accountRepository.findByAccountNumber(accountNumber);
        if (!existingAccount.isEmpty()){
            log.info("Account number already exist");
            return null;
        }
        account.setAccountNumber(accountNumber);
        log.info("Account is created");
        return accountRepository.save(account);
    }

    public List<Account> getAllAccount(){
        log.info("Getting all Account");
        return accountRepository.findAll();
    }

    public Account updateAccountName(int id, String name) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account with ID " + id + " not found"));
        account.setName(name);
        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }

    public void deleteAccount(int id){
        Optional<Account> existingAccount = accountRepository.findById(id);
        if (!existingAccount.isPresent()){
            log.info("Account number does not exist");
            return;
        }
        log.info("Account deleted");
        accountRepository.deleteById(id);

    }
}
