package com.internship.shakeapp.service.impl;

import com.internship.shakeapp.dao.CompanyDAO;
import com.internship.shakeapp.entity.Company;
import com.internship.shakeapp.service.CompanyService;
import com.internship.shakeapp.utils.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDAO companyDAO;

    public CompanyServiceImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyDAO.getCompanyById(id);
    }

    @Override
    public Company getCompanyByName(String companyName) {
        List<Company> companies = companyDAO.getCompanyByName(companyName);
        if (companies.size() == 1) {
            return companies.get(0);
        } else {
            return null;
        }
//        return companyDAO.getCompanyByName(companyName);
    }

    @Override
    public String register(Company company) {
        List<Company> companies = companyDAO.getCompanyByName(company.getCompanyName());
        if (companies.size() != 0) {
            return StringUtils.COMPANY_EXISTED;
        }

        company.setId(generateId()); // 设置存储于数据库中的ID

        try {
            companyDAO.register(company);
            return StringUtils.REGISTER_SUCCESS;
        } catch (Exception e) {
            return StringUtils.REGISTER_FAILED;
        }
    }

    private Long generateId() {
        List<Company> companies = companyDAO.getAll(true);
        if (companies.size() == 0) {
            return 1L;
        }
        Company lastCompany = companies.get(0);
        return lastCompany.getId() + 1;
    }
}
