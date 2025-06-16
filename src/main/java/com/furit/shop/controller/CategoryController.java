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

import com.furit.shop.service.CategoryService;
import com.furit.shop.vo.CategoryVO;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<CategoryVO> selectCategoryList(CategoryVO category){
		return categoryService.selectCategoryList(category);
	}
	
	@PostMapping("/categories")
	public int insertCategory(@RequestBody CategoryVO category) {
		return categoryService.insertCategory(category);
	}
	
	@PutMapping("/categories")
	public int updateCategory(@RequestBody CategoryVO category) {
		return categoryService.updateCategory(category);
	}
	
	@DeleteMapping("/categories/{ciNum}")
	public int deleteCategory(@PathVariable("ciNum") int ciNum) {
		return categoryService.deleteCategory(ciNum);
	}
}