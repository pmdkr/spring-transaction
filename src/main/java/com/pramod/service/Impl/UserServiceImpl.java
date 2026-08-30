package com.pramod.service.Impl;

import com.pramod.model.entity.User;
import com.pramod.repository.UserRepository;
import com.pramod.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public void debit(Long id, Double amount) {
        return userRepository.findById(id).orElseThrow("user not found");
    }

    @Override
    public void credit(Long id, Double amount) {
        return 0L;
    }
}
