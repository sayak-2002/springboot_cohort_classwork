package com.codihngshuttle.jpaLesson.jpaLessons.controllers;


import com.codihngshuttle.jpaLesson.jpaLessons.entities.ProductEntity;
import com.codihngshuttle.jpaLesson.jpaLessons.repositories.ProductRepository;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final int PAGE_SIZE = 5;
    private final ProductRepository  productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    // Sorting
    @GetMapping
    public List<ProductEntity> getAllProducts(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") Integer pageNumber) {

        return productRepository.findByTitleContainingIgnoreCase(
                title,
                PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy))
        );


//        return productRepository.findBy(Sort.by(sortBy));  // Default -> ascending
//        return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy, "price"));
        // descending
        // If String sortBy is same for multiple items then it will sort on basis of price.

//        return productRepository.findBy(
//                Sort.by(Sort.Order.desc(sortBy),
//                        Sort.Order.asc("price")
//                ));

//        Pageable pageable = PageRequest.of(
//                pageNumber,
//                PAGE_SIZE,
//                Sort.by(sortBy));
//
//        return productRepository.findAll(pageable).getContent();


    }
}
