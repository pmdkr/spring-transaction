package com.pramod.service;

import com.pramod.model.entity.User;

public interface UserService {

    User getUserById(Long id);

    void debit(Long id, Double amount);

    void credit(Long id, Double amount);

    User createUser(User user);
}
