package com.example.demo.service;

import com.example.demo.Dtos.ProductReviewDTO;
import com.example.demo.Dtos.SummaryReviewDTO;
import com.example.demo.Dtos.request.ProductReviewRequest;
import com.example.demo.repository.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ProductReviewService {
    @Autowired
    private ProductReviewRepository productReviewRepository;

    public Page<ProductReviewDTO> findAll(ProductReviewRequest productReviewRequest) {
        Pageable pageable = productReviewRequest.toPageable();
        var productReviews = productReviewRepository.findByProductID(productReviewRequest.getProductId(), productReviewRequest.getRating(), pageable);
        return productReviews.map(productReview -> new ProductReviewDTO(
                productReview.getProductID().getProductID(),
                productReview.getUserID().getFullName(),
                productReview.getUserID().getAvatar(),
                productReview.getRating(),
                productReview.getComment(),
                productReview.getCreatedAt()
        ));
    }

    public SummaryReviewDTO summaryReviews(ProductReviewRequest productReviewRequest) {
        productReviewRequest.setPage(0);
        productReviewRequest.setSize(5);
        Pageable pageable = productReviewRequest.toPageable();
        double avgRating = ((Number) Objects.requireNonNullElse(productReviewRepository.findAverageRating(productReviewRequest.getProductId()), 0)).doubleValue();
        List<Object[]> starCounts = productReviewRepository.countRatingByLevel(productReviewRequest.getProductId());
        long totalComments = ((Number) Objects.requireNonNullElse(productReviewRepository.countComments(productReviewRequest.getProductId()), 0)).longValue();
        List<ProductReviewDTO> comments = productReviewRepository.findTop5Comments(productReviewRequest.getProductId(), pageable);

        Map<Integer, Integer> starCount = new HashMap<>();
        for (Object[] row : starCounts) {
            try{
                Integer rating = row[0] != null ? ((Number) row[0]).intValue() : 0;
                Integer count = row[1] != null ? ((Number) row[1]).intValue() : 0;
                starCount.put(rating, count);
            } catch (NumberFormatException ignored){ }
        }

        for (int i = 1; i <= 5; i++) {
            starCount.putIfAbsent(i, 0);
        }


        return new SummaryReviewDTO(avgRating, totalComments, starCount,comments);
    }
}
