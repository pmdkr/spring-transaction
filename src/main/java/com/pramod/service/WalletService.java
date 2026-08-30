package com.pramod.service;


import org.springframework.stereotype.Service;

@Service
public class WalletService {

    UserService userService;

    public WalletService(UserService userService) {
        this.userService = userService;
    }

    public void transfer(Long senderId, Long reciverId, Double amount) {


        userService.debit(senderId, amount);
        userService.credit(reciverId, amount);


    }
}
