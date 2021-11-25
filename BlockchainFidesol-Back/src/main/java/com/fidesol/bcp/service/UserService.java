package com.fidesol.bcp.service;

import com.fidesol.bcp.service.dtos.UserData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    int login(UserData data);

    int getRol(String username);

    int upgrade(String username);

    int add(UserData data);
}
