package com.example.DOSOPTaladin.dto.request.review;

public record ReviewRequest(
        Long bookId,
        double score,
        String content
) {
}
