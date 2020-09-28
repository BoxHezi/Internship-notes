package com.internship.shakeapp.service;

import com.internship.shakeapp.entity.Company;
import com.internship.shakeapp.entity.Product;

import java.util.List;

public interface CompanyService {

    List<Company> getAll();

    Company getCompanyById(Long id);

    Company getCompanyByName(String companyName);

    String register(Company company);

    String addProduct(Product product, Long companyId);

}
