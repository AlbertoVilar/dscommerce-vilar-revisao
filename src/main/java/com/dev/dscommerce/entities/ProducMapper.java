package com.dev.dscommerce.entities;

import com.dev.dscommerce.dto.ProductDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducMapper {

    public static ProductDTO toProductDTO(Product entity) {

        ProductDTO dto = new ProductDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(dto.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setImgUrl(entity.getImgUrl());
        return dto;
    }

    public static Product toProduct(ProductDTO dto) {

       Product entity = new Product();

        //entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
        return entity;
    }
}
