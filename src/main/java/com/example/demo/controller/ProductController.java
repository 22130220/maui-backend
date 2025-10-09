package com.example.demo.controller;

import com.example.demo.Dtos.ProductDetailViewDTO;
import com.example.demo.Dtos.ProductViewDTO;
import com.example.demo.config.ResponseApi;
import com.example.demo.handler.ResponseStatus;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/get-list")
    public ResponseEntity<ResponseApi<List<ProductViewDTO>>> getAllProd() {
        return new ResponseEntity<>(new ResponseApi<>(ResponseStatus.SUCCESS, productService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ResponseApi<ProductDetailViewDTO>> getProd(@PathVariable("id") String id) {
        return new ResponseEntity<>(new ResponseApi<>(ResponseStatus.SUCCESS, productService.getDetail(id)), HttpStatus.OK);
    }


}
