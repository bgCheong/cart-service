package com.example.cartservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class AddCartItemDto {
	
	@NotNull
	private Long productId;
	@NotNull
	@Min(value = 1, message = "수량은 1개 이상이어야 합니다.")
	private Integer quantity;
	
	
}
