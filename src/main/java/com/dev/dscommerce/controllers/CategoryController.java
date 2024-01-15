package com.dev.dscommerce.controllers;

import com.dev.dscommerce.dto.CategoryDTO;
import com.dev.dscommerce.dto.ProductDTO;
import com.dev.dscommerce.dto.ProductMinDTO;
import com.dev.dscommerce.services.CategoryService;
import com.dev.dscommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    private CategoryService service;


    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findByPage() {
        List<CategoryDTO> listDTO = service.findAll();
        return ResponseEntity.ok(listDTO);
    }


}