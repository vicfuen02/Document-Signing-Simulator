package com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.repository.jpa;

import com.signingSimulator.signingSimulator.application.ports.output.UserDAO;
import com.signingSimulator.signingSimulator.domain.User;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.UserEntity;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.repository.mapper.UserServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserJpaAdapter implements UserDAO {


    private UserJpaRepository userJpaRepository;
    private UserServiceMapper userServiceMapper;


    @Autowired
    public UserJpaAdapter(UserJpaRepository userJpaRepository, UserServiceMapper userServiceMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userServiceMapper = userServiceMapper;
    }


    @Override
    public int createUser(User user) {
        return userJpaRepository.createUser(userServiceMapper.toEntity(user));
    }

    @Override
    public List<User> getAll() {
        return userServiceMapper.toListDTO(userJpaRepository.getAll());
    }

    @Override
    public User getById(String id) {
        return userServiceMapper.toDTO(userJpaRepository.getById(id));
    }

    @Override
    public User getByUserName(String userName) {
        return userServiceMapper.toDTO(userJpaRepository.getByUserName(userName));
    }
}
