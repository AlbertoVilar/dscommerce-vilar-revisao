package com.dev.dscommerce.entities;

import com.dev.dscommerce.dto.ProductDTO;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducMapper {

    public static void copProducToDTO(Product entity, ProductDTO dto) {


        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(dto.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setImgUrl(entity.getImgUrl());

    }

    public static void copyDTOToProduct(ProductDTO dto, Product entity) {


        //entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());


    }

}
