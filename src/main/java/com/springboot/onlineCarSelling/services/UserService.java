package com.springboot.onlineCarSelling.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.onlineCarSelling.entity.Item;
import com.springboot.onlineCarSelling.entity.UserTable;
import com.springboot.onlineCarSelling.repository.UserTableRepository;

@Service
public class UserService {
    private UserTableRepository userTableRepository;
    public UserService(UserTableRepository userTableRepository){
        this.userTableRepository=userTableRepository;
    }

    public UserTable saveUser(UserRequest user) throws IOException{
        UserTable u=new UserTable();
        u.setUserName(user.getUserName());
        u.setPassword(user.getPassword());
        u.setContentType(user.getDp().getContentType());
        u.setFileName(user.getDp().getOriginalFilename());
        u.setDp(user.getDp().getBytes());
        return userTableRepository.save(u);
    }
    public List<UserTable> getAllUsers(){
        return userTableRepository.findAll();
    }
    public UserTable getUserByName(String name){
        return userTableRepository.findByUserName(name);
    }

    public UserTable changeDp(ChangeDpRequest dp) throws IOException{
        UserTable user=userTableRepository.findByUserName(dp.getUserName());
        user.setContentType(dp.getDp().getContentType());
        user.setFileName(dp.getDp().getOriginalFilename());
        user.setDp(dp.getDp().getBytes());
        return userTableRepository.save(user);
    }

    public String signIn(SignInRequest signIn){
        UserTable user=userTableRepository.findByUserName(signIn.getName());
        if(user==null){
            return "invalid user";
        }
        if(user.getPassword().equals(signIn.getPassword())){
            return "ok";
        }
        else{
            return "Invalid Credentials";
        }
    }
}
