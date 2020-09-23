package com.internship.shakeapp.service;

import com.internship.shakeapp.entity.Product;

public interface ProductService {

    Product getRandomProduct();

    boolean checkStockCount(Product product);

    void updateStockCount(Product product);

}
