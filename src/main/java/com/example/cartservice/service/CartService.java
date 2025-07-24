package com.example.cartservice.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.cartservice.dto.AddCartItemDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {
	
	private final RedisTemplate<String , Object> redisTemplate;
	private static final String cartIdFrefix = "carts:id:";
	
	//상품담기
	public void addCart(String id , AddCartItemDto addItemDto)
	{
		//기존 담겨있던 상품 있다면 지워준다.
		String cartIdsuffix = cartIdFrefix+id;
		if(redisTemplate.opsForHash().get(cartIdsuffix,addItemDto.getProductId().toString())!=null)
		{
			redisTemplate.opsForHash().delete(cartIdsuffix, addItemDto.getProductId().toString());
		}
		
		redisTemplate.opsForHash().put(cartIdsuffix, addItemDto.getProductId().toString(), addItemDto.getQuantity());
	}
}
