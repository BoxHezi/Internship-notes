package com.internship.shakeapp.service;

import com.internship.shakeapp.entity.Company;
import com.internship.shakeapp.entity.Product;

public interface CompanyService {

    Company getCompanyById(Long id);

    Company getCompanyByName(String companyName);

    String register(Company company);

    String addProduct(Product product, Long companyId);

}
