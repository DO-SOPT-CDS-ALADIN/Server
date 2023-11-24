package com.example.DOSOPTaladin.service;

import com.example.DOSOPTaladin.domain.Book;
import com.example.DOSOPTaladin.dto.response.best.BestBookResponse;
import com.example.DOSOPTaladin.repository.BookJpaRepository;
import com.example.DOSOPTaladin.repository.HeartJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BestService {

    private final BookJpaRepository bookJpaRepository;
    private final HeartJpaRepository heartJpaRepository;

    public List<BestBookResponse> getBestBookList() {
        List<Book> books = bookJpaRepository.findAll();

        List<BestBookResponse> bestBookResponseList = new ArrayList<BestBookResponse>();

        for( Book book : books){
            BestBookResponse bestBookResponse = new BestBookResponse();
            bestBookResponse = new BestBookResponse(book, heartJpaRepository.existsByBook_Id(book.getId()));

            bestBookResponseList.add(bestBookResponse);
        }

        return bestBookResponseList;
    }
}
