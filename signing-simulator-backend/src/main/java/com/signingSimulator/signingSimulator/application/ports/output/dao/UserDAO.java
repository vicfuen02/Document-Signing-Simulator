package com.signingSimulator.signingSimulator.application.ports.output.dao;

import com.signingSimulator.signingSimulator.domain.User;



import java.util.List;

public interface UserDAO {

    User createUser(User userEntity);

    List<User> getAll();

    User getById(Long id);

    User getByUserName(String userName);



}
