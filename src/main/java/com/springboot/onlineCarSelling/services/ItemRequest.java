package com.springboot.onlineCarSelling.services;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemRequest {
    private String itemName;
    private float price;
    private String phno;
    private String location;
    private String kms;
    private MultipartFile image;
    private String ownerName;
}
