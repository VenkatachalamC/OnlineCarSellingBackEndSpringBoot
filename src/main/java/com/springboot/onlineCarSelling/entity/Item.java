package com.springboot.onlineCarSelling.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.http.MediaType;

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
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String itemName;
    private float price;
    private String phno;
    private String location;
    private String kms;
    private String fileName;
    private String contentType;

    @JsonIgnore
    @Lob
    private byte [] content;

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private UserTable user;
}
