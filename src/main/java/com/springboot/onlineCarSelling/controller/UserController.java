package com.springboot.onlineCarSelling.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.onlineCarSelling.entity.UserTable;
import com.springboot.onlineCarSelling.services.ChangeDpRequest;
import com.springboot.onlineCarSelling.services.ItemService;
import com.springboot.onlineCarSelling.services.SignInRequest;
import com.springboot.onlineCarSelling.services.UserRequest;
import com.springboot.onlineCarSelling.services.UserService;

import lombok.AllArgsConstructor;

@RestController
public class UserController {
    
    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/users")
    public List<UserTable> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/user")
    public UserTable addUser(@ModelAttribute UserRequest user) throws IOException{
        return userService.saveUser(user);
    }

    @GetMapping("/dp/{username}")
    public ResponseEntity<byte[]> getdp(@PathVariable String username){
        UserTable user=userService.getUserByName(username);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.valueOf(user.getContentType()));
        return new ResponseEntity<byte[]>(user.getDp(), httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/changedp")
    public UserTable changeDp(@ModelAttribute ChangeDpRequest req) throws IOException{
        return userService.changeDp(req);
    }
    //ok
    @PostMapping("/signin")
    public String login(@RequestBody SignInRequest signIn){
        String res=userService.signIn(signIn);
        return res;
    }   
} 
