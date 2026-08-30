package com.pramod.controller;

import com.pramod.model.entity.User;
import com.pramod.service.Impl.UserServiceImpl;
import com.pramod.service.UserService;
import com.pramod.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    WalletService walletService;

    public UserController(WalletService walletService) {
        this.walletService = walletService;
    }


    @GetMapping("/hello")
    String hello() {
        return "server is running";
    }


    @PostMapping("/transfer")
    public String transfer(
            @RequestParam Long senderId,
            @RequestParam Long receiverId,
            @RequestParam Double amount
    ) {

        try {
            walletService.transfer(senderId, receiverId, amount);

        }catch(Exception e){
            return "Transection failed: "+ e.getMessage();
        }
        return "Transection completed";

    }
}
