package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

}
