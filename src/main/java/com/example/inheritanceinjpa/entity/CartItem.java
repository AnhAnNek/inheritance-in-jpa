package com.example.inheritanceinjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer qty;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public CartItem() {
    }

    public CartItem(Long id, Integer qty, Product product) {
        this.id = id;
        this.qty = qty;
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", qty=" + qty +
                ", product=" + product +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
