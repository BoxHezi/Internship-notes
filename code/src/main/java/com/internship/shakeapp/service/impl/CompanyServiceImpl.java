package com.internship.shakeapp.service.impl;

import com.internship.shakeapp.dao.CompanyDAO;
import com.internship.shakeapp.dao.ProductDAO;
import com.internship.shakeapp.entity.Company;
import com.internship.shakeapp.entity.Product;
import com.internship.shakeapp.service.CompanyService;
import com.internship.shakeapp.utils.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDAO companyDAO;
    private final ProductDAO productDAO;

    public CompanyServiceImpl(CompanyDAO companyDAO, ProductDAO productDAO) {
        this.companyDAO = companyDAO;
        this.productDAO = productDAO;
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

    @Override
    public String addProduct(Product product, Long companyId) {
        Company company = companyDAO.getCompanyById(companyId);
        if (company == null) {
            return "企业不存在";
        }
        try {
            product.setId(generateProductId());
            product.setCompanyId(companyId);
            productDAO.addProduct(product);
            return "添加产品成功";
        } catch (Exception e) {
            return "添加产品失败";
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

    private Long generateProductId() {
        List<Product> products = productDAO.getAll(true);
        if (products.size() == 0) {
            return 1L;
        }
        Product lastProduct = products.get(0);
        return lastProduct.getId() + 1;
    }
}
