package com.signingSimulator.signingSimulator.application.ports.output;

import com.signingSimulator.signingSimulator.domain.User;



import java.util.List;

public interface UserDAO {

    Long createUser(User userEntity);

    List<User> getAll();

    User getById(Long id);

    User getByUserName(String userName);



}
