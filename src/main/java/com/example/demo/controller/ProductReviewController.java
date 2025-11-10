package com.example.demo.controller;

import com.example.demo.Dtos.ProductReviewDTO;
import com.example.demo.Dtos.SummaryReviewDTO;
import com.example.demo.Dtos.request.ProductReviewRequest;
import com.example.demo.Dtos.request.ReviewRequest;
import com.example.demo.Dtos.response.CheckoutResponse;
import com.example.demo.config.ResponseApi;
import com.example.demo.handler.ResponseStatus;
import com.example.demo.service.ProductReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/")
    public ResponseEntity<ResponseApi<?>> postComment(@RequestBody @Valid ReviewRequest reviewRequest) {
        try {
            boolean response = productReviewService.postComment(reviewRequest);
            if (response) {
                return new ResponseEntity<>(
                        new ResponseApi<>(ResponseStatus.CREATED, null),
                        HttpStatus.CREATED
                );
            } else {
                return new ResponseEntity<>(
                        new ResponseApi<>(ResponseStatus.INTERNAL_SERVER_ERROR, null),
                        HttpStatus.INTERNAL_SERVER_ERROR
                );
            }

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(
                    new ResponseApi<>(ResponseStatus.BAD_REQUEST, null),
                    HttpStatus.BAD_REQUEST
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseApi<>(ResponseStatus.INTERNAL_SERVER_ERROR, null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
