package com.dev.dscommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_order_item")
@NoArgsConstructor
public class OrderItem {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price;

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrderPK(order);
        id.setProductPK(product);
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrderPK() {

        return id.getOrderPK();
    }

    public void setOrderPK(Order order) {

        id.setOrderPK(order);
    }

    public Product getProductPK() {

        return id.getProductPK();
    }

    public void setProduct(Product product) {

        id.setProductPK(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
