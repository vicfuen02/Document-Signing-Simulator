package com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.repository.jpa;

import com.signingSimulator.signingSimulator.application.ports.output.dao.UserDAO;
import com.signingSimulator.signingSimulator.domain.User;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceException;
import com.signingSimulator.signingSimulator.domain.exceptions.SigningSimulatorServiceExceptionEnum;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.repository.mapper.UserServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserJpaAdapter implements UserDAO {


    private UserJpaRepository userJpaRepository;
    private UserServiceMapper userServiceMapper;


    @Autowired
    public UserJpaAdapter(UserJpaRepository userJpaRepository, UserServiceMapper userServiceMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userServiceMapper = userServiceMapper;
    }


    @Override
    public User createUser(User user) {
        return userServiceMapper.toDTO(
                userJpaRepository.save(
                        userServiceMapper.toEntity(user)
                )
        );
    }

    @Override
    public List<User> getAll() {
        return userServiceMapper.toListDTO(userJpaRepository.findAll());
    }


    public User getById(Long id) {
        return userServiceMapper.toDTO(
                userJpaRepository.findById(id).orElseThrow(() ->
                        new SigningSimulatorServiceException(SigningSimulatorServiceExceptionEnum.USER_NOT_FOUND))
        );
    }

    @Override
    public User getByUserName(String userName) {
        return userServiceMapper.toDTO(userJpaRepository.findByName(userName));
    }
}
