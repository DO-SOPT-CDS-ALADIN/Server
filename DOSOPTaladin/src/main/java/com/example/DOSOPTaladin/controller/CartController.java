package com.example.DOSOPTaladin.controller;


import com.example.DOSOPTaladin.dto.request.cart.PatchBookNumRequest;
import com.example.DOSOPTaladin.dto.response.best.BestBookResponse;
import com.example.DOSOPTaladin.dto.response.cart.MyCartResponse;
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

import java.util.List;

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


    @Operation(summary = "장바구니 개수 조회", description = "장바구니 개수 조회 API입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "장바구니에 담긴 개수 조회 완료."),
    })
    @GetMapping()
    public BaseApiResponse getCartNum(){
        return new BaseApiResponse("장바구니에 담긴 개수 조회 완료.", cartService.countCart());
    }

    @Operation(summary = "장바구니 목록 조회", description = "장바구니 목록 조회 API입니다.")
    @GetMapping(value = "/my")
    public BaseApiResponse<List<MyCartResponse>> getMyCartLists(){
        return new BaseApiResponse("장바구니 목록 조회 완료", cartService.getMyCartLists());
    }

    @Operation(summary = "장바구니 개수 변경", description = "장바구니 개수 변경 API입니다.")
    @PatchMapping("{bookId}")
    public BaseApiResponse<Integer> patchBookNum(@PathVariable Long bookId, @RequestBody PatchBookNumRequest patchBookNumRequest){
        return new BaseApiResponse<>("장바구니 개수 변경 완료", cartService.patchBookNum(bookId, patchBookNumRequest));
    }

    @Operation(summary = "장바구니 삭제", description = "장바구니 삭제 API입니다.")
    @DeleteMapping("{bookId}")
    public BaseApiResponseNonData deleteCart(@PathVariable Long bookId){
        cartService.deleteCart(bookId);
        return new BaseApiResponseNonData("장바구니 도서 삭제 완료");
    }
}
