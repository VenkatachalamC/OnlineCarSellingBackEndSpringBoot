package com.springboot.onlineCarSelling.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserTable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String userName;
    @JsonIgnore
    private String password; 
    private String contentType;
    private String fileName;

    @Lob
    @JsonIgnore
    private byte[] dp;
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL)
    @JsonIgnore 
    List<Item> items;
    
}
