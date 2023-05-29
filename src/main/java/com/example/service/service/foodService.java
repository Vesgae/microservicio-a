package com.example.service.service;

import com.example.service.entity.food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class foodService {

    @Autowired
    com.example.service.repository.foodRepo foodRepo;

    public List<food> getAll(){
        return  foodRepo.findAll();
    }

    public food getAllService(Integer id_service) {
        List<food> found = foodRepo.findAll();
        for (food trans : found) {
            if (trans.getId_service() == id_service) {
                return trans;
            }
        }
        return null;
    }

    public void saveFood(food newFood) {
        foodRepo.save(newFood);
    }

    public void deleteFood(Integer id) {
        foodRepo.deleteById(id);
    }

}
