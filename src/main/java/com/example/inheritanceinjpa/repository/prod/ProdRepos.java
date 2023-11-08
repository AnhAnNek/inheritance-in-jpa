package com.example.inheritanceinjpa.repository.prod;

import com.example.inheritanceinjpa.entity.Product;
import com.example.inheritanceinjpa.repository.base.BaseRepos;

public interface ProdRepos extends BaseRepos<Product, Long> {
    Product update(Product prod);
}

