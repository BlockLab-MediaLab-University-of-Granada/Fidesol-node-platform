package com.fidesol.bcp.controller;

import com.fidesol.bcp.config.MysqlConfig;
import com.fidesol.bcp.exception.ResourceNotFoundException;
import com.fidesol.bcp.service.UserService;
import com.fidesol.bcp.service.dtos.UserData;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@ContextConfiguration(classes = {MysqlConfig.class})
@RequestMapping("/user-management")
@Api(tags = "Usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Login, a JSON object with user and password keys is given as body.

     * @param UserData
     * @return
     * @throws ResourceNotFoundException
     */
    @PostMapping("/login")
    public ResponseEntity<Integer> getLogin(@RequestBody UserData data) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.login(data));
    }

    /**
     * Add a new user, a JSON object with user and password keys is given as body.

     * @param UserData
     * @return
     * @throws ResourceNotFoundException
     */
    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody UserData data) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.add(data));
    }

    /**
     * Get the user rol.

     * @param String 
     * @return
     * @throws ResourceNotFoundException
     */
    @PostMapping("/rol")
    public ResponseEntity<Integer> getRol(@RequestBody String username) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.getRol(username));
    }

    /**
     * Make the given user an admin.

     * @param String
     * @return
     * @throws ResourceNotFoundException
     */
    @PostMapping("/upgrade")
    public ResponseEntity<Integer> upgrade(@RequestBody String username) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.upgrade(username));
    }

}
