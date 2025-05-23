package com.signingSimulator.signingSimulator.application.ports.output;

import com.signingSimulator.signingSimulator.domain.User;



import java.util.List;

public interface UserDAO {

    int createUser(User userEntity);

    List<User> getAll();

    User getById(String id);

    User getByUserName(String userName);



}
