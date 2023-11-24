package com.example.DOSOPTaladin.service;

import com.example.DOSOPTaladin.domain.Book;
import com.example.DOSOPTaladin.domain.Review;
import com.example.DOSOPTaladin.dto.request.review.ReviewRequest;
import com.example.DOSOPTaladin.repository.BookJpaRepository;
import com.example.DOSOPTaladin.repository.ReviewJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final ReviewJpaRepository reviewJpaRepository;
    private final BookJpaRepository bookJpaRepository;

    public void createReview(ReviewRequest reviewRequest){
        Book book = bookJpaRepository.findByIdOrThrow(reviewRequest.bookId());
        Review review = reviewJpaRepository.save(
                Review.builder()
                        .book(book)
                        .score(reviewRequest.score())
                        .content(reviewRequest.content())
                .build()
        );
    }

}
