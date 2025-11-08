package com.example.demo.controller;

import com.example.demo.Dtos.ProductReviewDTO;
import com.example.demo.Dtos.SummaryReviewDTO;
import com.example.demo.Dtos.request.ProductReviewRequest;
import com.example.demo.config.ResponseApi;
import com.example.demo.handler.ResponseStatus;
import com.example.demo.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-reviews")
public class ProductReviewController {
    @Autowired
    private ProductReviewService productReviewService;

    @GetMapping("/get-list")
    public ResponseEntity<ResponseApi<Page<ProductReviewDTO>>> getList(@ModelAttribute @Validated ProductReviewRequest productReviewRequest) {
        return new ResponseEntity<>(new ResponseApi<>(ResponseStatus.SUCCESS, productReviewService.findAll(productReviewRequest)), HttpStatus.OK);
    }

    @GetMapping("/summary-review")
    public ResponseEntity<ResponseApi<SummaryReviewDTO>> getSummaryReview(@ModelAttribute @Validated ProductReviewRequest productReviewRequest) {
        return new ResponseEntity<>(new ResponseApi<>(ResponseStatus.SUCCESS, productReviewService.summaryReviews(productReviewRequest)), HttpStatus.OK);
    }
}
