package com.furit.shop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.furit.shop.service.CategoryService;
import com.furit.shop.service.ProductService;
import com.furit.shop.vo.CategoryVO;
import com.furit.shop.vo.ProductVO;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class ViewsController {
	private final ProductService productService;
	private final CategoryService categoryService;
	

	@GetMapping("/")
	public String home(Model m, ProductVO product) {
		List<ProductVO> products = productService.selectProductList(null);
		m.addAttribute("products",products);
		List<CategoryVO> categories = categoryService.selectCategoryList(null);
		m.addAttribute("categories",categories);
		return "index";
	}
	
	@GetMapping("/views/**")
	public void goPage() {}
	
}
