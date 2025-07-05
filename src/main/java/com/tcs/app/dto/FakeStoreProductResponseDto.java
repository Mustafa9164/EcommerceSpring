package com.tcs.app.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor
@Builder
public class FakeStoreProductResponseDto {
	private ProductDto product;
	private String message;
	private String status;
}