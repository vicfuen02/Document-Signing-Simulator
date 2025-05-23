package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest;

import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.UserReqDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.dto.UserResDTO;
import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.mapper.UserRestControllerMapper;
import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.UserEntity;
import com.signingSimulator.signingSimulator.application.ports.input.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);


    private UserService userService;

    private UserRestControllerMapper userRestControllerMapper;

    @Autowired
    public UserRestController(UserService userService, UserRestControllerMapper userRestControllerMapper) {
        this.userService = userService;
        this.userRestControllerMapper = userRestControllerMapper;
    }

    @GetMapping("/")
    public List<UserResDTO> getAll() {
        return this.userRestControllerMapper.toListResDTO(this.userService.getAll());
    }

    @GetMapping("/{id}")
    public UserResDTO getById(String id) {
        return this.userRestControllerMapper.toResDTO(this.userService.getById(id));
    }

    @PostMapping("/createUser")
    public UserResDTO createUser(@RequestBody UserReqDTO user) {
        LOGGER.info("create user controller: " + user.toString());

        UserResDTO userCreated = userRestControllerMapper.toResDTO(this.userService.createUser(userRestControllerMapper.toDTO(user)));

        return userCreated;
    }


}
