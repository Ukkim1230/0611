package com.furit.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.furit.shop.service.ProductService;
import com.furit.shop.vo.ProductVO;

@RestController
public class ProductController {
	@Autowired
	private ProductService ProductService;
	
	@GetMapping("/products")
	public List<ProductVO> selectProductList(ProductVO Product){
		return ProductService.selectProductList(Product);
	}
	
	@PostMapping("/products")
	public int insertProduct(@ModelAttribute ProductVO Product) {
		return ProductService.insertProduct(Product);
	}
	
	@PutMapping("/products")
	public int updateProduct(@RequestBody ProductVO Product) {
		return ProductService.updateProduct(Product);
	}
	
	@DeleteMapping("/products/{piNum}")
	public int deleteProduct(@PathVariable("piNum") int piNum) {
		return ProductService.deleteProduct(piNum);
	}
}