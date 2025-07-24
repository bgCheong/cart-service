package com.example.cartservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cartservice.dto.AddCartItemDto;
import com.example.cartservice.service.CartService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	private final CartService cartService;
	
	@PostMapping("/add")
	public void addCarts(@RequestHeader("X-User-Id") String id , @Valid @RequestBody AddCartItemDto addCartItemDto)
	{
		logger.info("장바구니 Id : {}",id);
		logger.info("들어온 데이터 : {}",addCartItemDto);
		
		cartService.addCart(id, addCartItemDto);
		
	}
}
