package com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest;


import com.signingSimulator.signingSimulator.infrastructure.adapter.output.persistance.entity.UserEntity;
import com.signingSimulator.signingSimulator.common.interceptors.CacheEnum;
import com.signingSimulator.signingSimulator.application.ports.input.CacheService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BaseRestController {

    Logger LOGGER = LoggerFactory.getLogger(BaseRestController.class);

    @Autowired
    private CacheService cacheService;


    protected static String TOKEN_HEADER = "X-User-Token";
    protected static String VISIBILITY_HEADER = "Access-Control-Expose-Headers";

    private String getTokenFromHeaders(HttpServletRequest headers) {
        return headers.getHeader(TOKEN_HEADER);
    }

    protected Boolean isUserLogged(HttpServletRequest headers) {

        Map<String, Object> cacheUsers = this.cacheService.getStoredValues(CacheEnum.LOGGED_USERS.getCode());
        return cacheUsers.containsKey(this.getTokenFromHeaders(headers));
    }

    private Map<String, Object> getCacheUsers() {
        return this.cacheService.getStoredValues(CacheEnum.LOGGED_USERS.getCode());
    }

    public Boolean hasAccess(HttpServletRequest request) {

        Boolean isUserLogged = this.isUserLogged(request);
        if (!isUserLogged) {
            return false;
        }

        UserEntity user = (UserEntity) this.getCacheUsers().get(this.getTokenFromHeaders(request));

        Boolean hasAccess = user != null;
        LOGGER.info("is user logged: " + hasAccess);
        return hasAccess;
    }



}
