package com.ichangge.ssh.demo.service;

import com.ichangge.ssh.demo.dao.UserRepository;
import com.ichangge.ssh.demo.model.UserEntity;

import java.util.List;

public class UserService {
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> listUser() {
        return userRepository.listUser();
    }
}
