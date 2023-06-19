package com.springboot.onlineCarSelling.services;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRequest {
    private String userName;
    private String password;
    private MultipartFile dp;
}
