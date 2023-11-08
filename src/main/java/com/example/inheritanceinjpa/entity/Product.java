package com.example.inheritanceinjpa.entity;

import com.example.inheritanceinjpa.customenum.ECategory;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String brand;

    protected String model;

    @Column(name = "description")
    protected String desc;

    protected BigDecimal price;

    @Column(name = "stock_qty")
    protected Integer stockQty;

    @Column(name = "discount_percent")
    protected double discountPercent;

    protected String version;

    protected String color;

    @Column(name = "release_year")
    protected int releaseYear;

    @Enumerated(EnumType.STRING)
    protected ECategory category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> cartItems;

    public Product() {
    }

    public Product(String brand, String model, String desc, BigDecimal price, Integer stockQty,
                   double discountPercent, String version, String color, ECategory category, int releaseYear) {
        this.brand = brand;
        this.model = model;
        this.desc = desc;
        this.price = price;
        this.stockQty = stockQty;
        this.discountPercent = discountPercent;
        this.version = version;
        this.color = color;
        this.category = category;
        this.releaseYear = releaseYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStockQty() {
        return stockQty;
    }

    public void setStockQty(Integer stockQty) {
        this.stockQty = stockQty;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ECategory getCategory() {
        return category;
    }

    public void setCategory(ECategory category) {
        this.category = category;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
