package com.example.test1q1.service;

import com.example.test1q1.entity.UserAccount;
import com.example.test1q1.repository.UserAccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserAccountService {

    private final UserAccountRepo userAccountRepo;

    public UserAccount save(UserAccount userAccount){
        return userAccountRepo.save(userAccount);
    }

    public void delete(long account){
        userAccountRepo.deleteById(account);
    }

    public List<UserAccount> getAll(){
        return userAccountRepo.findAll();
    }

    public UserAccount getByAccount(Long account){
        return userAccountRepo.findById(account).orElseThrow(()->
            new NoSuchElementException(String.format("There is no element with account %s", account))
        );
    }
    public List<UserAccount> getAllByName(String name){
        return userAccountRepo.findAllByName(name);
    }
    public List<UserAccount> getAllByValue(double value){
        return userAccountRepo.findAllByValue(value);
    }

}
