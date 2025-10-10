package com.example.demo.Dtos;

import com.example.demo.entity.Category;
import com.example.demo.entity.Specification;
import com.example.demo.entity.Subimage;

import java.time.LocalDateTime;
import java.util.List;

public record ProductDetailViewDTO(
        String productID,
        String name,
        Integer price,
        Integer discountDefault,
        String thumbnail,
        Category categoryID,
        List<Subimage> subImages,
        Integer quantityStock,
        Integer quantitySell,
        LocalDateTime createAt,
        Integer minStockLevel,
        SpecificationProductDetailDTO specification
) { }
