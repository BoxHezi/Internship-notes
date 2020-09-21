package com.internship.shakeapp.service;

import com.internship.shakeapp.entity.Company;

public interface CompanyService {

    Company getCompanyById(Long id);

    Company getCompanyByName(String companyName);

    String register(Company company);

}
