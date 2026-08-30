package com.pramod.service;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    UserService userService;

    public WalletService(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    public void transfer(Long senderId, Long receiverId, Double amount) {

        userService.debit(senderId, amount);
        userService.credit(receiverId, amount);


    }
}
