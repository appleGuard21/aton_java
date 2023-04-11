package com.example.test1q1.repository;

import com.example.test1q1.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, Long> {

    List<UserAccount> findAllByName(String name);
    List<UserAccount> findAllByValue(double value);

}
