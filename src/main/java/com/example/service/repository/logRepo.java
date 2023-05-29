package com.example.service.repository;

import com.example.service.entity.log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  logRepo extends JpaRepository<log, Integer> {

}
