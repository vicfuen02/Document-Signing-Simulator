package com.signingSimulator.signingSimulator.common.interceptors;

import com.signingSimulator.signingSimulator.infrastructure.adapter.input.rest.BaseRestController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationInterceptor implements HandlerInterceptor {

    Logger LOGGER = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @Autowired
    private BaseRestController baseRestController;

    @Value("${allow.notLoggedUsers}")
    private Boolean allowNotLoggedUsers;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (this.allowNotLoggedUsers) {
            return true;
        }

        LOGGER.info(request.getRequestURI());
        String uri = request.getRequestURI();
        if (uri.equals("/login/login")) {
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }

        Boolean hasAccess = this.baseRestController.hasAccess(request);

        if (!hasAccess) {
            response.getWriter().write(RestControllerExceptionEnum.USER_NOT_LOGGED.getMessage());
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }

        return hasAccess;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
