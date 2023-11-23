package com.example.DOSOPTaladin.controller;


import com.example.DOSOPTaladin.dto.response.best.BestBookResponse;
import com.example.DOSOPTaladin.service.common.CartService;
import com.example.DOSOPTaladin.util.BaseApiResponse;
import com.example.DOSOPTaladin.util.BaseApiResponseNonData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "CartController")
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @Operation(summary = "장바구니 추가", description = "장바구니 추가 API입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "장바구니 추가 완료"),
            @ApiResponse(responseCode = "400", description = "유효한 책 id를 보냈는지 확인해주세요.")
    })
    @PostMapping()
    public BaseApiResponseNonData postSaveCart(@RequestParam("bookId")int bookId){
        cartService.saveCart(bookId);
        return new BaseApiResponseNonData("장바구니에 담기 완료.");
    }
}
