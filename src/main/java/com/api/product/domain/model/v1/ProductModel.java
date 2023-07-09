package com.api.product.domain.model.v1;


import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_product")
public class ProductModel implements Serializable {

    private final Long serialVersionUId = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_product;

    @Column(length = 50)
    private String nameProduct;

    @Column(length = 100)
    private String productPrice;

    @Column(length = 100)
    private String storeName;

    @Column(length = 100)
    private String productsQuantity;

    public Long getSerialVersionUId() {
        return serialVersionUId;
    }

    public UUID getId_product() {
        return id_product;
    }

    public void setId_product(UUID id_product) {
        this.id_product = id_product;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProductsQuantity() {
        return productsQuantity;
    }

    public void setProductsQuantity(String productsQuantity) {
        this.productsQuantity = productsQuantity;
    }
}
