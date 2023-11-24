package com.example.DOSOPTaladin.repository;

import com.example.DOSOPTaladin.domain.Book;
import com.example.DOSOPTaladin.domain.Cart;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartJpaRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByBook(Book book);

    default Cart findByBookOrThrow(Book book) {
        return findByBook(book)
                .orElseThrow(() -> new EntityNotFoundException("해당 책이 카트에 없습니다."));
    }
}
