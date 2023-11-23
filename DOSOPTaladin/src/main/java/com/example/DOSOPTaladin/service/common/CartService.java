package com.example.DOSOPTaladin.service.common;

import com.example.DOSOPTaladin.domain.Book;
import com.example.DOSOPTaladin.domain.Cart;
import com.example.DOSOPTaladin.repository.BookJpaRepository;
import com.example.DOSOPTaladin.repository.CartJpaRepository;
import com.example.DOSOPTaladin.util.BaseApiException;
import com.example.DOSOPTaladin.util.error.BadRequestException;
import com.example.DOSOPTaladin.util.error.ErrorResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartService {

    private final CartJpaRepository cartJpaRepository;
    private final BookJpaRepository bookJpaRepository;

    public void saveCart(int bookId) {
        Book book = bookJpaRepository.findById(Long.valueOf(bookId)).orElseThrow(() -> new  BadRequestException(ErrorResponseStatus.BAD_REQUEST_MISSING_VALUE));

        Cart cart = new Cart(book, 1);

        cartJpaRepository.save(cart);

    }
}
