package com.springboot.onlineCarSelling.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.springboot.onlineCarSelling.entity.Item;
import com.springboot.onlineCarSelling.entity.UserTable;
import com.springboot.onlineCarSelling.repository.ItemRepository;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    public Item addItem(ItemRequest it,UserTable user) throws IOException{
        System.out.println(user.getUserName());
        System.out.println(it.getImage().getBytes());
        System.out.println(it.getImage().getContentType());
        Item item=new Item();
        item.setItemName(it.getItemName());
        try {
            item.setContent(it.getImage().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        item.setFileName(it.getImage().getOriginalFilename());
        item.setKms(it.getKms());
        item.setLocation(it.getLocation());
        item.setPrice(it.getPrice());
        item.setPhno(it.getPhno());
        item.setUser(user);
        item.setContentType(it.getImage().getContentType());
        return itemRepository.save(item);
        //return new Item();
    }

    public List<Item> getAll(){
        return itemRepository.findAll();
    }

    public Item getImage(String filename){
        return itemRepository.findByFileName(filename);
    }
}
