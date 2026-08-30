package com.pramod.service.Impl;

import com.pramod.model.entity.User;
import com.pramod.repository.UserRepository;
import com.pramod.service.UserService;
import org.springframework.stereotype.Service;


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
    public void debit(Long id, Double amount) {
        User user = userRepository.findById(id).orElseThrow();
        user.setBalance(amount);
        userRepository.save(user);

    }

    @Override
    public void credit(Long id, Double amount) {
        User user = userRepository.findById(id).orElseThrow();

        user.setBalance(amount);
        userRepository.save(user);
    }

    @Override
    public User createUser(User user) {
//        User res = userRepository.findById(user.getId()).orElseThrow();
//        if(res != null){
//            throw new Exception("user already present in database");
//        }


        return userRepository.save(user);
    }

    ;
}
