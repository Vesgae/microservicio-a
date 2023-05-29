package com.example.service.service;

import com.example.service.entity.transport;
import com.example.service.repository.transportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class transportService {

    @Autowired
    com.example.service.repository.transportRepo transportRepo;

    public List<transport> getAll(){
        return transportRepo.findAll();
    }

    public transport getAllService(Integer id_service) {
        List<transport> found = transportRepo.findAll();
        for (transport trans : found) {
            if (trans.getId_service() == id_service) {
                return trans;
            }
        }
        return null;
    }

    public void saveTransport(transport newTrans) {
        transportRepo.save(newTrans);
    }

    public void deleteFood(Integer id) {
        transportRepo.deleteById(id);
    }

}
