package com.example.casestudy.controller;

import com.example.casestudy.model.Customer;
import com.example.casestudy.model.CustomerType;
import com.example.casestudy.service.CustomerService;
import com.example.casestudy.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("home/")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("")
    public ModelAndView getHome() {
        return new ModelAndView("home");
    }

    @GetMapping("customer")
    public ModelAndView getCustomerList(@PageableDefault(size = 5) Pageable pageable, @RequestParam("search") Optional<String> search) {
        Page<Customer> customers;
        if (search.isPresent()) {
            customers = customerService.findAllByNameContaining(search.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        return new ModelAndView("customer/list", "customers", customers);
    }
    @GetMapping("/create")
    public ModelAndView getCreatePage(Model model) {
        List<CustomerType> customerTypes = (List<CustomerType>) customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypes);
        return new ModelAndView("customer/create", "customers", new Customer());
    }
    @PostMapping("/create")
    public String saveCustomer(@Validated @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<CustomerType> customerTypes = (List<CustomerType>) customerTypeService.findAll();
            model.addAttribute("customerTypes", customerTypes);
            //  model.addAttribute("customer", new Customer());
            return "create";
        } else {
            customerService.saveCustomer(customer);
            redirectAttributes.addFlashAttribute("message", "Create success");
            return "redirect:/";
        }
    }

}
