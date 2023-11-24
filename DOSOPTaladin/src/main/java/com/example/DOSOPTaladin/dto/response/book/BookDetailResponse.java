package com.example.DOSOPTaladin.dto.response.book;

import com.example.DOSOPTaladin.domain.Book;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Schema(description = "도서 상세 정보 응답DTO")
public record BookDetailResponse(
        Long id,
        String imgUrl,
        String title,
        String subtitle,
        String writer,
        String painter,
        String publisher,
        String pubDate,
        double star,
        int tag,
        String discountPrice,
        String originPrice,
        String mileage,
        boolean heart

) {

}
