package com.signingSimulator.signingSimulator.application.ports.input;

import com.signingSimulator.signingSimulator.domain.User;

import java.util.List;


public interface UserService {


    List<User> getAll();

    User getById(String id);

    User getByUserName(String userName);

    User createUser(User user);


}
