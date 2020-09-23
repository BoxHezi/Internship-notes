package com.internship.shakeapp.dao;

import com.internship.shakeapp.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductDAO {

    List<Product> getAll(Boolean descOrder);

    void addProduct(Product product);

    void updateStockCount(Product product);

}
