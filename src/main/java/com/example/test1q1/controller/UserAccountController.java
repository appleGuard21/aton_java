package com.example.test1q1.controller;

import com.example.test1q1.entity.UserAccount;
import com.example.test1q1.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/userAccount")
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserAccount userAccount){
        if (userAccount.getAccount() == null){
            throw new IllegalArgumentException("account can not be null");
        }
        return ResponseEntity.ok(userAccountService.save(userAccount));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserAccount userAccount){
        return ResponseEntity.ok(userAccountService.save(userAccount));
    }

    @DeleteMapping("/delete/{account}")
    public void delete(@PathVariable Long account){
        userAccountService.delete(account);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userAccountService.getAll());
    }

    @GetMapping("/getByAccount/{account}")
    public ResponseEntity<?> getByAccount(@PathVariable Long account){
        return ResponseEntity.ok(userAccountService.getByAccount(account));
    }

    @GetMapping("/getAllByName/{name}")
    public ResponseEntity<?> getAllByName(@PathVariable String name){
        return ResponseEntity.ok(userAccountService.getAllByName(name));
    }

    @GetMapping("/getAllByValue/{value}")
    public ResponseEntity<?> getAllByValue(@PathVariable double value){
        return ResponseEntity.ok(userAccountService.getAllByValue(value));
    }

}
