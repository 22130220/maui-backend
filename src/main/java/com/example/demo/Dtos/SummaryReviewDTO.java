package com.example.demo.Dtos;

import java.util.List;
import java.util.Map;

public record SummaryReviewDTO(
        double avgRating,
        long totalComments,
        Map<Integer, Integer> starCount,
        List<ProductReviewDTO> topFiveComment,
        boolean hasComment
) { }
