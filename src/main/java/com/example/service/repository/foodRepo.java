package com.example.service.repository;


import com.example.service.entity.food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface foodRepo extends JpaRepository<food, Integer> {
}
