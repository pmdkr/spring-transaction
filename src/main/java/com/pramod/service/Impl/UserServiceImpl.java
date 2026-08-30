package com.pramod.service.Impl;

import com.pramod.exception.UserAlreadyExistException;
import com.pramod.model.entity.User;
import com.pramod.repository.UserRepository;
import com.pramod.service.UserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;


    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }


    @Override
    public User createUser(User user) {
        Optional<User> existingUser = userRepository.findByName(user.getName());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistException("User with name '" + user.getName() + "' already exists.");
        }


        return userRepository.save(user);
    }


    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void debit(Long id, Double amount) {
        User user = userRepository.findById(id).orElseThrow();
        user.setBalance(user.getBalance() - amount);
        userRepository.save(user);

    }

    @Override
    public void credit(Long id, Double amount) {
        User user = userRepository.findById(id).orElseThrow();

        user.setBalance(user.getBalance() + amount);


        //creating exception explictly
        int x = 10 / 0;
        userRepository.save(user);
    }


}
