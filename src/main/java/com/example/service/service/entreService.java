package com.example.service.service;

import com.example.service.entity.entre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class entreService {
    @Autowired
    com.example.service.repository.entreRepo entreRepo;

    public List<entre>getAll(){
        return entreRepo.findAll();
    }

    public entre getAllService(Integer id_service) {
        List<entre> found = entreRepo.findAll();
        for (entre trans : found) {
            if (trans.getId_service() == id_service) {
                return trans;
            }
        }
        return null;
    }

    public void saveService(entre newEntre) {
        entreRepo.save(newEntre);
    }

    public void deleteService(Integer id) {
        entreRepo.deleteById(id);
    }

}
