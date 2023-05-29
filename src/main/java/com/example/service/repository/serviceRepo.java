package com.example.service.repository;

import com.example.service.entity.service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface serviceRepo extends JpaRepository<service, Integer> {

    List<service> findAllByCategory(String category);
    //List<service> findAllById_supplier(Integer id);
}
