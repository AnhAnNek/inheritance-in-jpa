package com.example.inheritanceinjpa.repository.prod;

import com.example.inheritanceinjpa.entity.Product;
import com.example.inheritanceinjpa.repository.base.BaseReposImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdReposImpl extends BaseReposImpl<Product, Long> implements ProdRepos {

    private final Logger log = Logger.getLogger(ProdReposImpl.class.getName());

    public ProdReposImpl() {
        super();
    }

    @Override
    protected Class<Product> getClassType() {
        return Product.class;
    }

    @Override
    public Product update(Product prod) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(prod);
            trans.commit();
            return prod;
        } catch (NoResultException e) {
            log.log(Level.SEVERE, e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public List<Product> getByPriceRange(BigDecimal startPrice, BigDecimal endPrice) {
        return new ArrayList<>();
//        return getResultList(em -> {
//            String sqlStr = "SELECT p FROM Product p WHERE p.price >= :startPrice AND p.price <= :endPrice";
//            TypedQuery<Product> typedQuery = em.createQuery(sqlStr, Product.class);
//            typedQuery.setParameter("startPrice", startPrice);
//            typedQuery.setParameter("endPrice", endPrice);
//            return typedQuery;
//        });
    }

    @Override
    public List<Product> getProdsByModel(String model) {
        return new ArrayList<>();
//        return getResultList(em -> {
//            String sqlStr = "SELECT p FROM Product p WHERE p.model LIKE :model";
//            String sqlStr = "SELECT p FROM Product p";
//            TypedQuery<Product> typedQuery = em.createQuery(sqlStr, Product.class);
//            typedQuery.setParameter("model", model);
//            return typedQuery;
//        });
    }
}
