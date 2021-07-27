package com.codegym.model.service;

import com.codegym.model.entity.User;
import com.codegym.model.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;
    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }
}
