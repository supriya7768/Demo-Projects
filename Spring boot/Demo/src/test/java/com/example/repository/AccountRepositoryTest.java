//package com.example.repository;
//
//import com.example.model.Account;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//public class AccountRepositoryTest {
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    @BeforeEach
//    void setup() {
//        // Pre-populate some test data
//        accountRepository.save(new Account(0, "Alice", 1234, "CityA", 5000));
//        accountRepository.save(new Account(0, "Bob", 5678, "CityB", 7000));
//    }
//
//    @Test
//    void findByAccountNumber_ExistingAccount() {
//        int accountNumber = 1234;
//
//        List<Account> accounts = accountRepository.findByAccountNumber(accountNumber);
//
//        assertThat(accounts).isNotEmpty();
//        assertThat(accounts.get(0).getName()).isEqualTo("Alice");
//        assertThat(accounts.get(0).getAccountNumber()).isEqualTo(accountNumber);
//    }
//
//    @Test
//    void findByAccountNumber_NonExistingAccount() {
//        int accountNumber = 9999;
//
//        List<Account> accounts = accountRepository.findByAccountNumber(accountNumber);
//
//        assertThat(accounts).isEmpty();
//    }
//
//    @Test
//    void saveAccount_NewAccount() {
//        Account newAccount = new Account(0, "Charlie", 4321, "CityC", 3000);
//
//        Account savedAccount = accountRepository.save(newAccount);
//
//        assertThat(savedAccount.getId()).isNotNull();
//        assertThat(savedAccount.getName()).isEqualTo(newAccount.getName());
//        assertThat(savedAccount.getAccountNumber()).isEqualTo(newAccount.getAccountNumber());
//    }
//
//    @Test
//    void findById_ExistingAccount() {
//        Optional<Account> account = accountRepository.findById(1); // Assuming first saved account gets ID 1
//
//        assertThat(account).isPresent();
//        assertThat(account.get().getName()).isEqualTo("Alice");
//    }
//
//    @Test
//    void findById_NonExistingAccount() {
//        Optional<Account> account = accountRepository.findById(999);
//
//        assertThat(account).isNotPresent();
//    }
//
//    @Test
//    void deleteById_ExistingAccount() {
//        int id = 1; // Assuming first saved account gets ID 1
//
//        accountRepository.deleteById(id);
//
//        Optional<Account> deletedAccount = accountRepository.findById(id);
//
//        assertThat(deletedAccount).isNotPresent();
//    }
//
//    @Test
//    void findAllAccounts() {
//        List<Account> accounts = accountRepository.findAll();
//
//        assertThat(accounts).hasSize(2); // Initially populated with 2 accounts
//        assertThat(accounts.get(0).getName()).isEqualTo("Alice");
//        assertThat(accounts.get(1).getName()).isEqualTo("Bob");
//    }
//}
