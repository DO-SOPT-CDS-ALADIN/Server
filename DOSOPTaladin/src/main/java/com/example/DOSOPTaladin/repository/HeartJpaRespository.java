package com.example.DOSOPTaladin.repository;

import com.example.DOSOPTaladin.domain.Book;
import com.example.DOSOPTaladin.domain.Heart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartJpaRespository extends JpaRepository<Heart, Long> {

    boolean existsByBookId(long bookId);

}
