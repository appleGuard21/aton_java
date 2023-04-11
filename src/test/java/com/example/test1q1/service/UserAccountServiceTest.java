package com.example.test1q1.service;

import com.example.test1q1.entity.UserAccount;
import com.example.test1q1.repository.UserAccountRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserAccountServiceTest {

    @Mock
    private UserAccountRepo userAccountRepo;
    private UserAccountService underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserAccountService(userAccountRepo);
    }

    @Test
    void save(){
        UserAccount userAccount = UserAccount.builder()
                .account(234678L)
                .name("Иванов Иван Иванович")
                .value(2035.34)
                .build();
        underTest.save(userAccount);
        ArgumentCaptor<UserAccount> userArgumentCaptor = ArgumentCaptor.forClass(UserAccount.class);
        verify(userAccountRepo).save(userArgumentCaptor.capture());
        UserAccount capturedUser = userArgumentCaptor.getValue();
        assertEquals(capturedUser, userAccount);
    }
    @Test
    void delete(){
        underTest.delete(0L);
        verify(userAccountRepo).deleteById(0L);
    }
    @Test
    void getAll(){
        underTest.getAll();
        verify(userAccountRepo).findAll();
    }
    @Test
    void getByAccountException(){
        NoSuchElementException thrown = assertThrows(NoSuchElementException.class, ()-> underTest.getByAccount(0L));
        assertEquals("There is no element with account 0", thrown.getMessage());
    }
    @Test
    void getAllByName(){
        underTest.getAllByName("");
        verify(userAccountRepo).findAllByName("");
    }
    @Test
    void getAllByValue(){
        underTest.getAllByValue(0);
        verify(userAccountRepo).findAllByValue(0);
    }


}
