package com.example.casestudy.service.impl;

import com.example.casestudy.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements com.example.casestudy.service.Service {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<com.example.casestudy.model.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void saveService(com.example.casestudy.model.Service service) {
        serviceRepository.save(service);

    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);

    }

    @Override
    public com.example.casestudy.model.Service findServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }
}
