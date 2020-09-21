package com.internship.shakeapp.dao;

import com.internship.shakeapp.entity.Company;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CompanyDAO {

    List<Company> getAll(Boolean descOrder);

    Company getCompanyById(Long id);

    List<Company> getCompanyByName(String companyName);

    void register(Company company);
}
