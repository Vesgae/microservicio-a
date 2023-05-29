package com.example.service.repository;


import com.example.service.entity.entre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  entreRepo  extends JpaRepository<entre, Integer> {
}
