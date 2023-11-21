package com.example.DOSOPTaladin.repository;

import com.example.DOSOPTaladin.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Long> {
}
