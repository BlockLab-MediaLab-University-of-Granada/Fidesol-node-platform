package com.fidesol.bcp.infrastructure;

import com.fidesol.bcp.domain.repository.mysql.UserRepository;
import com.fidesol.bcp.service.UserService;
import com.fidesol.bcp.service.dtos.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    //Add a new user. Generates the token
    public int add(UserData data){
        int token=(data.getName()+data.getPassword()).hashCode();
        userRepository.add(data.getName(),data.getPassword(),token);

        return  userRepository.getToken(data.getName());
    }

    //Check if the user credentials are ok.
    public int login(UserData data){
        int token=0;
        String pass= userRepository.login(data.getName());

        if(pass!=null){
            if(pass.equals(data.getPassword())){
                token=userRepository.getToken(data.getName());
            }
        }

        return token;
    }

    //Get the user rol
    public int getRol(String username){
        return userRepository.getRol(username);
    }

    //Upgrade the given user to admin
    public int upgrade(String username){
        userRepository.upgrade(username);
        return userRepository.getRol(username);
    }
}
