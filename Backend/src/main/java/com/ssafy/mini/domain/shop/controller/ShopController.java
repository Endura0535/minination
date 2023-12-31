package com.ssafy.mini.domain.shop.controller;

import com.ssafy.mini.domain.shop.dto.request.AddProductRequest;
import com.ssafy.mini.domain.shop.dto.request.BuyProductRequest;
import com.ssafy.mini.domain.shop.dto.request.DeleteProductRequest;
import com.ssafy.mini.domain.shop.service.ProductService;
import com.ssafy.mini.global.jwt.JwtProvider;
import com.ssafy.mini.global.response.EnvelopeResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shop")
@RequiredArgsConstructor
public class ShopController {

    private final ProductService productService;
    private final JwtProvider jwtProvider;

    @GetMapping
    @ApiOperation(value = "구매할 수 있는 물품 리스트")
    @ApiResponses({
            @ApiResponse(code = 200, message = "물품 조회 성공"),
            @ApiResponse(code = 403, message = "유효하지 않은 토큰"),
            @ApiResponse(code = 404, message = "물품 조회 실패")
    })
    public EnvelopeResponse listProducts(
            @RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken
    ) {
        String memberId = jwtProvider.extractMemberId(accessToken);
        return EnvelopeResponse.builder()
                .data(productService.listProducts(memberId))
                .build();
    }

    @PutMapping
    @ApiOperation(value = "상품 추가")
    @ApiResponses({
            @ApiResponse(code = 200, message = "물품 추가 성공"),
            @ApiResponse(code = 402, message = "권한 없음"),
            @ApiResponse(code = 403, message = "유효하지 않은 토큰"),
            @ApiResponse(code = 404, message = "물품 추가 실패")
    })
    public EnvelopeResponse addProduct(
            @RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken,
            @RequestBody @ApiParam(value = "추가할 상품 정보", required = true) AddProductRequest addProductRequest
    ) {
        String memberId = jwtProvider.extractMemberId(accessToken);
        productService.addProduct(memberId, addProductRequest);
        return EnvelopeResponse.builder()
                .build();
    }

    @DeleteMapping
    @ApiOperation(value = "상품 삭제")
    @ApiResponses({
            @ApiResponse(code = 200, message = "물품 삭제 성공"),
            @ApiResponse(code = 402, message = "권한 없음"),
            @ApiResponse(code = 403, message = "유효하지 않은 토큰"),
            @ApiResponse(code = 404, message = "물품 삭제 실패")
    })
    public EnvelopeResponse deleteProduct (
            @RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken,
            @RequestBody @ApiParam(value = "삭제할 상품 정보", required = true)DeleteProductRequest deleteProductRequest
            ) {
        String memberId = jwtProvider.extractMemberId(accessToken);
        productService.deleteProduct(memberId, deleteProductRequest);
        return EnvelopeResponse.builder()
                .build();
    }

    @PostMapping("/buy")
    @ApiOperation(value = "물품 구매")
    @ApiResponses({
            @ApiResponse(code = 200, message = "물품 구매 성공"),
            @ApiResponse(code = 403, message = "유효하지 않은 토큰"),
            @ApiResponse(code = 404, message = "물품 구매 실패"),
            @ApiResponse(code = 406, message = "잔액 부족")
    })
    public EnvelopeResponse buyProduct (
            @RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken,
            @RequestBody @ApiParam(value = "구매할 상품 정보", required = true)BuyProductRequest buyProductRequest
            ) {
        String memberId = jwtProvider.extractMemberId(accessToken);
        productService.buyProduct(memberId, buyProductRequest);
        return EnvelopeResponse.builder()
                .build();
    }

    @PostMapping("/use")
    @ApiOperation(value = "물품 사용")
    @ApiResponses({
            @ApiResponse(code = 200, message = "물품 사용 성공"),
            @ApiResponse(code = 406, message = "보유한 물품 수량 부족"),
            @ApiResponse(code = 403, message = "유효하지 않은 토큰"),
            @ApiResponse(code = 404, message = "물품 구매 실패")
    })
    public EnvelopeResponse useProduct (
            @RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken,
            @RequestBody @ApiParam(value = "사용할 상품 정보", required = true) DeleteProductRequest deleteProductRequest
    ) {
        String memberId = jwtProvider.extractMemberId(accessToken);
        productService.useProduct(memberId, deleteProductRequest);
        return EnvelopeResponse.builder()
                .build();
    }

    @GetMapping("/my")
    @ApiOperation(value = "내가 가진 품목 리스트")
    @ApiResponses({
            @ApiResponse(code = 200, message = "물품 조회 성공"),
            @ApiResponse(code = 403, message = "유효하지 않은 토큰"),
            @ApiResponse(code = 404, message = "물품 조회 실패")
    })
    public EnvelopeResponse useProduct (
            @RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken
    ) {
        String memberId = jwtProvider.extractMemberId(accessToken);
        productService.listMyProducts(memberId);
        return EnvelopeResponse.builder()
                .data(productService.listMyProducts(memberId))
                .build();
    }
}
