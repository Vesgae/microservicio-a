package com.example.service.service;

import com.example.service.entity.log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class logService {
    @Autowired
    com.example.service.repository.logRepo logRepo;

    public List<log> getAll(){
        return logRepo.findAll();
    }


    public log getAllService(Integer id_service) {
        List<log> found = logRepo.findAll();
        for (log trans : found) {
            if (trans.getId_service() == id_service) {
                return trans;
            }
        }
        return null;
    }

    public void saveLog(log newLog) {
        logRepo.save(newLog);
    }

    public void deleteFood(Integer id) {
        logRepo.deleteById(id);
    }

}
