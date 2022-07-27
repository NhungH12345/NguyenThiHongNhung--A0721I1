package com.example.casestudy.controller;

import com.example.casestudy.model.RentType;
import com.example.casestudy.model.ServiceType;
import com.example.casestudy.service.RentTypeService;
import com.example.casestudy.service.Service;
import com.example.casestudy.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ServiceController {
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private Service service;
    @Autowired
    private RentTypeService rentTypeService;

    @GetMapping("service")
    private ModelAndView getServiceList(Model model) {
        List<ServiceType> serviceTypes = serviceTypeService.findAll();
        model.addAttribute("serviceTypes", serviceTypes);
        List<RentType> rentTypeServices = rentTypeService.findAll();
        model.addAttribute("rentTypes", rentTypeServices);
        return new ModelAndView("service/list", "services", service.findAll());
    }

}
