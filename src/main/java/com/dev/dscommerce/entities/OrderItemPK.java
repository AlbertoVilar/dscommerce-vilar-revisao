package com.dev.dscommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class OrderItemPK {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderPK;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productPK;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(orderPK, that.orderPK) && Objects.equals(productPK, that.productPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderPK, productPK);
    }
}
