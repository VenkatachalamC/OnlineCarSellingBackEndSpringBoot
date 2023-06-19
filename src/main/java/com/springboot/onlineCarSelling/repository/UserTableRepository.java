package com.springboot.onlineCarSelling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.onlineCarSelling.entity.Item;
import com.springboot.onlineCarSelling.entity.UserTable;

@Repository
public interface UserTableRepository extends JpaRepository<UserTable,Long> {
    UserTable findByUserName(String name);
    
}
