package com.signingSimulator.signingSimulator.application.service;

import com.signingSimulator.signingSimulator.application.ports.output.dao.UserDAO;
import com.signingSimulator.signingSimulator.domain.User;
import com.signingSimulator.signingSimulator.application.ports.input.UserService;
import com.signingSimulator.signingSimulator.common.interceptors.PasswordsUtils;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordsUtils passwordsUtils;


    public List<User> getAll() {
        return this.userDAO.getAll();
    }

    public User getById(Long id) {
        return this.userDAO.getById(id);
    }

    public User getByUserName(String userName) {
        return this.userDAO.getByUserName(userName);
    }


    @Transactional
    public User createUser(User user) {

        user.setPassword(this.passwordsUtils.encryptPass(user.getPassword()));
        return this.userDAO.createUser(user);
    }


}
