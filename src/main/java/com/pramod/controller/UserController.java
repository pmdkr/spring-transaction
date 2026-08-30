package com.pramod.controller;

import com.pramod.model.entity.User;
import com.pramod.service.Impl.UserServiceImpl;
import com.pramod.service.UserService;
import com.pramod.service.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    WalletService walletService;
    UserService userService;

    public UserController(WalletService walletService, UserService userService) {
        this.walletService = walletService;
        this.userService = userService;
    }


    @GetMapping("/hello")
    String hello() {
        return "spring transaction server is running";
    }


    @PostMapping("/create-user")
    ResponseEntity<User> createUser(@RequestBody User user) {

        User res = userService.createUser(user);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    @PostMapping("/transfer")
    public String transfer(
            @RequestParam Long senderId,
            @RequestParam Long receiverId,
            @RequestParam Double amount
    ) {

        try {
            walletService.transfer(senderId, receiverId, amount);

        } catch (Exception e) {
            return "Transection failed: " + e.getMessage();
        }
        return "Transection completed";

    }
}
