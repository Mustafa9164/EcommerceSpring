package com.tcs.app.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto{
	private String image;
	private String color;
	private int price;
	private String description;
	private int discount;
	private String model;
	/*private int id;*/
	private String title;
	private Long categoryId;
	private String brand;
	private boolean popular;
}