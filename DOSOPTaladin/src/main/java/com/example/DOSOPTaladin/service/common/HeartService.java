package com.example.DOSOPTaladin.service.common;


import com.example.DOSOPTaladin.domain.Book;
import com.example.DOSOPTaladin.domain.Heart;
import com.example.DOSOPTaladin.repository.BookJpaRepository;
import com.example.DOSOPTaladin.repository.HeartJpaRepository;
import com.example.DOSOPTaladin.util.error.BadRequestException;
import com.example.DOSOPTaladin.util.error.ErrorResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HeartService {

    private final HeartJpaRepository heartJpaRepository;
    private final BookJpaRepository bookJpaRepository;

    @Transactional
    public void clickHeart(int bookId){
        Book book = bookJpaRepository.findById(Long.valueOf(bookId)).orElseThrow(() -> new BadRequestException(ErrorResponseStatus.BAD_REQUEST_MISSING_VALUE));  //book 조회

        if(heartJpaRepository.existsByBook_Id(bookId) == true){
            Heart heart = heartJpaRepository.findByBook(book);
            heartJpaRepository.delete(heart);
        } else {
            Heart heart = new Heart(book);
            heartJpaRepository.save(heart);
        }
    }

}
