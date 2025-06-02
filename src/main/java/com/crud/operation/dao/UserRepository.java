package com.crud.operation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.operation.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
