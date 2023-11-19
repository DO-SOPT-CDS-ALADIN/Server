package com.example.DOSOPTaladin.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "book")
public class Book extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String img;

    private String title;

    private String subTitle;

    private String writer;

    private String publisher;

    private LocalDateTime pubDate;

    private int price;

    private int point;

    private int score;

    private int tag;

}
