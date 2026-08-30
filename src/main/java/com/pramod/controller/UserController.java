package com.pramod.controller;

import com.pramod.model.entity.User;
import com.pramod.service.Impl.UserServiceImpl;
import com.pramod.service.UserService;
import com.pramod.service.WalletService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class UserController {

    WalletService walletService;
    UserService userService;

    //    Logger log = Logger.getLogger("UserController.class");
    //private static final Logger log = (Logger) LoggerFactory.getLogger(UserController.class);

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

       // log.info("sender id: " + senderId);
       // log.info("revicer id: " + receiverId);


        try {
            walletService.transfer(senderId, receiverId, amount);
           // log.info("Transfer completed successfully.");

        } catch (Exception e) {
            return "Transection failed: " + e.getMessage();
        }
        return "Transection completed";

    }
}
