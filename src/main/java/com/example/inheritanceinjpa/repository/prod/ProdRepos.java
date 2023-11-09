package com.example.inheritanceinjpa.repository.prod;

import com.example.inheritanceinjpa.entity.Product;
import com.example.inheritanceinjpa.repository.base.BaseRepos;

import java.math.BigDecimal;
import java.util.List;

public interface ProdRepos extends BaseRepos<Product, Long> {
    Product update(Product prod);
    List<Product> getByPriceRange(BigDecimal startPrice, BigDecimal endPrice);
}

