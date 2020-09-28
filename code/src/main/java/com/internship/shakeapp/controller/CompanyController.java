package com.internship.shakeapp.controller;

import com.internship.shakeapp.entity.Company;
import com.internship.shakeapp.entity.Product;
import com.internship.shakeapp.service.impl.CompanyServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {

    private final CompanyServiceImpl companyService;

    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    public List<Company> getAllCompanies() {
        return companyService.getAll();
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
    public String register(@RequestBody Company company) {
        companyService.register(company);
        return "注册成功";
    }

    @PostMapping(value = "{companyId}/addProduct")
    public String addProduct(@RequestBody Product product, @PathVariable Long companyId) {
        return companyService.addProduct(product, companyId);
    }


    // Redis Test!!!!!!!!!!!!!!
//    @GetMapping("all")
//    public Map<Long, Company> testAll() {
//        return companyService.getAllCompany();
//    }
//
//    @GetMapping("testSave/{id}/{name}")
//    public Company testSave(@PathVariable Long id, @PathVariable String name) {
//        Company company = new Company();
//        company.setId(id);
//        company.setCompanyName(name);
//        companyService.saveCompany(company);
//        return companyService.findById(id);
//    }

}
