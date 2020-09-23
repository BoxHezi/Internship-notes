package com.internship.shakeapp.service.impl;

import com.internship.shakeapp.dao.ProductDAO;
import com.internship.shakeapp.entity.Product;
import com.internship.shakeapp.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public Product getRandomProduct() {
        List<Product> products = productDAO.getAll(false);
        Product tempProduct;
        do {
            tempProduct = products.get(new Random().nextInt(products.size()));
        } while (!checkStockCount(tempProduct)); // 保证奖品库存大于0
        return tempProduct;
    }

    @Override
    public boolean checkStockCount(Product product) {
        return product.getStockCount() > 0;
    }

    @Override
    public void updateStockCount(Product product) {
        product.setStockCount(product.getStockCount() - 1);
        try {
            productDAO.updateStockCount(product);
        } catch (Exception ignored) {
        }
    }
}
