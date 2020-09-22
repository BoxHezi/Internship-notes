package com.internship.shakeapp.controller;

import com.internship.shakeapp.entity.Company;
import com.internship.shakeapp.entity.Product;
import com.internship.shakeapp.service.impl.CompanyServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("company")
public class CompanyController {

    private final CompanyServiceImpl companyService;

    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @GetMapping(params = "id")
    public Company welcomePage(@RequestParam Long id) {
        return companyService.getCompanyById(id);
    }

    @GetMapping(params = "companyName")
    public Company welcomePage(@RequestParam String companyName) {
        return companyService.getCompanyByName(companyName);
    }

    @PostMapping(value = "register")
    public String register(@RequestParam Company company) {
        companyService.register(company);
        return "注册成功";
    }

    @PostMapping(value = "{id}/addProduct")
    public String addProduct(Product product) {
        return "Add product";

    }

}
