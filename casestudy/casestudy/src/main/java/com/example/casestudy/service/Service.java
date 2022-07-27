package com.example.casestudy.service;


import com.example.casestudy.model.ServiceType;

import java.util.List;

public interface Service {
    List<com.example.casestudy.model.Service> findAll();
    void saveService(com.example.casestudy.model.Service service);//pt thêm mơi và update(tự hieu gióng id la update)
    void deleteService(Long id);
    com.example.casestudy.model.Service findServiceById(Long id);
}
