package com.example.DOSOPTaladin.controller;

import com.example.DOSOPTaladin.dto.request.review.ReviewRequest;
import com.example.DOSOPTaladin.service.ReviewService;
import com.example.DOSOPTaladin.util.BaseApiResponseNonData;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "ReviewController")
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("")
    public BaseApiResponseNonData createReview(@RequestBody ReviewRequest reviewRequest){
        reviewService.createReview(reviewRequest);
        return new BaseApiResponseNonData("도서 리뷰 등록 완료");
    }

}
