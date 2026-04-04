package com.cg.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ProductDto {

    private Integer productId;

    @NotBlank(message = "Product name is required")
    @Pattern(regexp = "^[A-Za-z]{3,}$", message = "Name must have only alphabets and min 3 chars")
    private String productName;

    @NotNull(message = "Price is required")
    @Min(value = 1, message = "Price must be at least 1")
    @Max(value = 500000, message = "Price must not exceed 500000")
    private Double price;

    @NotBlank(message = "Category is required")
    @Pattern(regexp = "mobile|laptop", message = "Category must be either 'mobile' or 'laptop'")
    private String category;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

    
}