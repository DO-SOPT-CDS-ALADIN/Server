package com.example.DOSOPTaladin.service;

import com.example.DOSOPTaladin.domain.Book;
import com.example.DOSOPTaladin.domain.Heart;
import com.example.DOSOPTaladin.dto.response.best.BestBookResponse;
import com.example.DOSOPTaladin.dto.response.main.EditorChoiceResponse;
import com.example.DOSOPTaladin.repository.BookJpaRepository;
import com.example.DOSOPTaladin.repository.HeartJpaRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BestService {

    private final BookJpaRepository bookJpaRepository;
    private final HeartJpaRespository heartJpaRespository;

    public List<BestBookResponse> getBestBookList() {
        List<Book> books = bookJpaRepository.findAll();

        List<BestBookResponse> bestBookResponseList = new ArrayList<BestBookResponse>();

        for( Book book : books){
            BestBookResponse bestBookResponse = new BestBookResponse();
            bestBookResponse = new BestBookResponse(book, heartJpaRespository.existsByBook_Id(book.getId()));

            bestBookResponseList.add(bestBookResponse);
        }

        return bestBookResponseList;
    }
}
