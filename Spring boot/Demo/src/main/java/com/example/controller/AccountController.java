package com.example.controller;

import com.example.model.Account;
import com.example.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/hello")
    public void hello(){
        System.out.println("Hello");
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        log.info("Account create request is received");
        Account createAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccount(){
        log.info("Getting all account request is received");
        List<Account> getAllAccount = accountService.getAllAccount();
        return ResponseEntity.status(HttpStatus.FOUND).body(getAllAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateName(@PathVariable int id, @RequestParam String name){
        log.info("Update Account name request is received");
        Account updatedAccount = accountService.updateAccountName(id, name);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable int id){
        log.info("Delete account request received");
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Deleted account with id : " + id);
    }
}
