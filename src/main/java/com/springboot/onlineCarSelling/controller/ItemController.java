package com.springboot.onlineCarSelling.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.multipart.MultipartFile;

import com.springboot.onlineCarSelling.entity.Item;
import com.springboot.onlineCarSelling.entity.UserTable;
import com.springboot.onlineCarSelling.services.ItemRequest;
import com.springboot.onlineCarSelling.services.ItemService;
import com.springboot.onlineCarSelling.services.UserService;

@RestController
public class ItemController {
 
    @Autowired 
    private ItemService itemService;
    @Autowired
    private UserService userService;
    @PostMapping("/item")
    public Item addItem(@ModelAttribute ItemRequest it) throws IOException{
        System.out.println(it);
        UserTable user=userService.getUserByName(it.getOwnerName());
        return itemService.addItem(it,user);
    }  

    @GetMapping("/items")
    public List<Item> getAllItems(){
        return itemService.getAll();
    }

    @GetMapping("/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable String filename){
        Item it=itemService.getImage(filename);
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.valueOf(it.getContentType()));
        return new ResponseEntity<byte[]>(it.getContent(),httpHeaders,HttpStatus.OK);
    }
}
