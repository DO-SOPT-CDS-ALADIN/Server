package com.example.DOSOPTaladin.service;

import com.example.DOSOPTaladin.domain.Book;
import com.example.DOSOPTaladin.dto.response.main.EditorChoiceResponse;
import com.example.DOSOPTaladin.repository.BookJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainService {

    private final BookJpaRepository bookJpaRepository;

    public List<EditorChoiceResponse> getEditorChoice() {
        return  bookJpaRepository.findAll()
                .stream()
                .map(EditorChoiceResponse::of)
                .collect(Collectors.toList());
    }
}
