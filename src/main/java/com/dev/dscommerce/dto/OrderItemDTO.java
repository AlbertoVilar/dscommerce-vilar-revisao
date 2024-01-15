package com.dev.dscommerce.dto;

import com.dev.dscommerce.entities.OrderItem;

public class OrderItemDTO {
    private Long productId;
    private String name;
    private Double price;
    private Integer quantity;
    private String umgUrl;

    public OrderItemDTO(Long productId, String name, Double price, Integer quantity, String umgUrl) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.umgUrl = umgUrl;
    }

    public OrderItemDTO(OrderItem entity) {
        productId = entity.getProductPK().getId();
        name = entity.getProductPK().getName();
        price = entity.getPrice();
        quantity = entity.getQuantity();
        umgUrl = entity.getProductPK().getImgUrl();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getUmgUrl() {
        return umgUrl;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    //Crianto um metodo para retornar o subtotal já que, é um valor calculado
    //Usando o get como nome padrão para o Json
    public Double getSubtotal() {
        return price * quantity;
    }
}
