package com.example.service.service;

import com.example.service.entity.service;
import com.example.service.repository.serviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceService {

    @Autowired
    private com.example.service.repository.serviceRepo serviceRepo;


    public List<service> getALlServices() {
        return serviceRepo.findAll();
    }

    public List<service> getAllCategory(String category) {
        return serviceRepo.findAllByCategory(category);
    }

    public service getJustOne(Integer idSer) {
        return serviceRepo.findById(idSer).get();
    }

    public void saveService(service newService) {
        serviceRepo.save(newService);
    }

    public int updateService(service updateService) {
        if (serviceRepo.findById(updateService.getId_service()).get() == null) {
            return -1;
        } else {
            service foundSer = serviceRepo.findById(updateService.getId_service()).get();
            foundSer.setAvailability(updateService.getAvailability());
            foundSer.setCategory(updateService.getCategory());
            foundSer.setDuration(updateService.getDuration());
            foundSer.setName(updateService.getName());
            foundSer.setPhoto_url(updateService.getPhoto_url());
            foundSer.setPrice(updateService.getPrice());
            serviceRepo.save(foundSer);
            return 1;
        }
    }

    public void deleteService(Integer id) {
        serviceRepo.deleteById(id);
    }


}
