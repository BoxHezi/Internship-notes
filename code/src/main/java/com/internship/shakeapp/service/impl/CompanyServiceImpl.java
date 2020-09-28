package com.internship.shakeapp.service.impl;

import com.internship.shakeapp.dao.CompanyDAO;
import com.internship.shakeapp.dao.ProductDAO;
import com.internship.shakeapp.entity.Company;
import com.internship.shakeapp.entity.Product;
import com.internship.shakeapp.service.CompanyService;
import com.internship.shakeapp.utils.ReturnMsgUtils;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDAO companyDAO;
    private final ProductDAO productDAO;

//    public CompanyServiceImpl(CompanyDAO companyDAO, ProductDAO productDAO) {
//        this.companyDAO = companyDAO;
//        this.productDAO = productDAO;
//    }

    private final RedisTemplate<String, Company> redisTemplate;
    private final HashOperations hashOperations;

    public CompanyServiceImpl(CompanyDAO companyDAO, ProductDAO productDAO, RedisTemplate<String, Company> redisTemplate) {
        this.companyDAO = companyDAO;
        this.productDAO = productDAO;
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    // redis test
    public void saveCompany(Company company) {
        hashOperations.put("COMPANY", company.getId(), company);
    }

    public Map<Long, Company> getAllCompany() {
        return hashOperations.entries("COMPANY");
    }

    public Company findById(Long id) {
//        RedisOperations ops = hashOperations.getOperations();
//        System.out.println(ops);
//        Company test = (Company) hashOperations.get("COMPANY", "test company");
        return (Company) hashOperations.get("COMPANY", id);
    }
    // end redis test


    @Override
    public List<Company> getAll() {
        Map<Long, Company> companyMap = getAllCompany();
        List<Company> companies = new ArrayList<>();
        // 检查缓存
        if (companyMap.size() == 0) {
            companies = companyDAO.getAll(false);
            for (Company company : companies) {
                hashOperations.put("COMPANY", company.getId(), company);
            }
        } else {
            for (Map.Entry<Long, Company> entry : companyMap.entrySet()) {
                companies.add(entry.getValue());
            }
        }
        return companies;
    }

    /**
     * 根据ID获取企业用户信息
     * 先查缓存, 若缓存中没有数据, 再到数据库中查找
     *
     * @param id 企业用户ID
     * @return 企业用户
     */
    @Override
    public Company getCompanyById(Long id) {
        Company company = findById(id);
        // 检查缓存
        if (company != null) {
            return company;
        } else {
            company = companyDAO.getCompanyById(id);
            saveCompany(company);
        }
        return company;
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
            return ReturnMsgUtils.COMPANY_EXISTED;
        }

        company.setId(generateId()); // 设置存储于数据库中的ID

        try {
            companyDAO.register(company);
            return ReturnMsgUtils.REGISTER_SUCCESS;
        } catch (Exception e) {
            return ReturnMsgUtils.REGISTER_FAILED;
        }
    }

    @Override
    public String addProduct(Product product, Long companyId) {
        Company company = companyDAO.getCompanyById(companyId);
        if (company == null) {
            return ReturnMsgUtils.COMPANY_NOT_EXISTED;
        }
        try {
            product.setId(generateProductId());
            product.setCompanyId(companyId);
            productDAO.addProduct(product);
            return ReturnMsgUtils.ADD_PRODUCT_SUCCESS;
        } catch (Exception e) {
            return ReturnMsgUtils.ADD_PRODUCT_FAILED;
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
