package com.example.service.repository;

import com.example.service.entity.transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface transportRepo  extends JpaRepository<transport, Integer> {


}
