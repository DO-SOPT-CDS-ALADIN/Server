package com.example.DOSOPTaladin.repository;

import com.example.DOSOPTaladin.domain.Book;
import com.example.DOSOPTaladin.domain.Heart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartJpaRepository extends JpaRepository<Heart, Long> {

    boolean existsByBook_Id(long bookId); //Heart에서 Book이 FK인데, 그 Book의 Id를 사용해서 Heart가 있는지 조회
//    boolean existsByBookId(long bookId);

    Heart findByBook(Book book);

}
