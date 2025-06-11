package com.furit.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	private ProductService prService;
	
	@GetMapping("/products")
	public List<ProductVO> selectProductList(ProductVO product){
		return prService.selectProductList(product);
	}
	@PostMapping("/products")
	public int insertProduct(@RequestBody ProductVO product) {
		return prService.insertProduct(product);
	}
	@PutMapping("/products")
	public int updateProduct(@RequestBody ProductVO product) {
		return prService.updateProduct(product);
	}
	@DeleteMapping("/products/{piNum}")
	public int deleteProduct(@PathVariable("piNum") int piNum) {
		return prService.deleteProduct(piNum);
	}
}
