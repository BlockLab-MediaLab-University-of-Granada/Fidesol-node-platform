package com.fidesol.bcp.config;

import com.fidesol.bcp.domain.model.mysql.User;
import com.fidesol.bcp.domain.repository.mysql.UserRepository;
import com.fidesol.bcp.exception.ResourceNotFoundException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptors implements HandlerInterceptor {

    @Autowired
    private UserRepository userRepository;

    private static final String XAPIKEY = "x-api-key";
    private static final String NOTAUTHORIZED = "Not authorized";

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
                             Object handler) throws Exception {

        if (!req.getRequestURI().contains("/login")) {
            if (Strings.isEmpty(req.getHeader(XAPIKEY)) || req.getHeader(XAPIKEY) == null) {
                throw new ResourceNotFoundException(NOTAUTHORIZED);
            } else {
                try {
                    User u = userRepository.findOneByToken(req.getHeader(XAPIKEY));
                    if (u == null) {
                        throw new ResourceNotFoundException(NOTAUTHORIZED);
                    }
                } catch (Exception e) {
                    throw new ResourceNotFoundException(NOTAUTHORIZED);
                }
            }
        }


        return true;
    }
}

