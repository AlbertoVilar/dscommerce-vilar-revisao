package com.dev.dscommerce.dto;

import com.dev.dscommerce.entities.User;

public class ClientMinDTO {
    private Long id;
    private String name;

    public ClientMinDTO() {
    }

    public ClientMinDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientMinDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
