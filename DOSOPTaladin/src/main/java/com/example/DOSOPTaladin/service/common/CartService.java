package com.example.DOSOPTaladin.service.common;

import com.example.DOSOPTaladin.domain.Book;
import com.example.DOSOPTaladin.domain.Cart;
import com.example.DOSOPTaladin.dto.request.cart.PatchBookNumRequest;
import com.example.DOSOPTaladin.dto.response.cart.MyCartResponse;
import com.example.DOSOPTaladin.dto.response.common.CountCartResponse;
import com.example.DOSOPTaladin.repository.BookJpaRepository;
import com.example.DOSOPTaladin.repository.CartJpaRepository;
import com.example.DOSOPTaladin.repository.HeartJpaRepository;
import com.example.DOSOPTaladin.util.error.BadRequestException;
import com.example.DOSOPTaladin.util.error.ErrorResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartService {

    private final CartJpaRepository cartJpaRepository;
    private final BookJpaRepository bookJpaRepository;
    private final HeartJpaRepository heartJpaRepository;

    public void saveCart(int bookId) {
        Book book = bookJpaRepository.findById(Long.valueOf(bookId)).orElseThrow(() -> new  BadRequestException(ErrorResponseStatus.BAD_REQUEST_MISSING_VALUE));

        Cart cart = new Cart(book, 1);

        cartJpaRepository.save(cart);
    }

    public CountCartResponse countCart(){
        return new CountCartResponse((int) cartJpaRepository.count());
    }

    public List<MyCartResponse> getMyCartLists(){
        List<Cart> carts = cartJpaRepository.findAll();
        return carts.stream()
                .map(this::mapToMyCartResponse)
                .collect(Collectors.toList());
    }

    private MyCartResponse mapToMyCartResponse(Cart cart) {
        Book book = cart.getBook();
        boolean isHearted = heartJpaRepository.existsByBook_Id(book.getId());

        return new MyCartResponse(
                book.getId(),
                book.getImg(),
                book.getTitle(),
                book.getSubTitle(),
                book.getTag(),
                toDiscountPrice(book.getPrice()),
                toMileage(book.getMileage()),
                isHearted
        );
    }

    @Transactional
    public int patchBookNum(Long bookId, PatchBookNumRequest patchBookNumRequest){
        Book book = bookJpaRepository.findByIdOrThrow(bookId);
        Cart cart = cartJpaRepository.findByBookOrThrow(book);
        cart.setNum(patchBookNumRequest.count());

        return cart.getNum();
    }

    @Transactional
    public void deleteCart(Long bookId){
        Book book = bookJpaRepository.findByIdOrThrow(bookId);
        Cart cart = cartJpaRepository.findByBookOrThrow(book);
        cartJpaRepository.delete(cart);
    }

    private String toDiscountPrice(int price){
        price = (int) Math.ceil(price * 0.9);
        String won = Integer.toString(price);
        return won.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",") + "원";
    }

    private String toMileage(int price){
        String won = Integer.toString(price);
        return won.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",") + "원";
    }


}
