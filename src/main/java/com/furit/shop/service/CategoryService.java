package com.furit.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furit.shop.mapper.CategoryMapper;
import com.furit.shop.vo.CategoryVO;

@Service
public class CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	public List<CategoryVO> selectCategoryList(CategoryVO category){
		return categoryMapper.selectCategoryList(category);
	}
	public int insertCategory(CategoryVO category) {
		return categoryMapper.insertCategory(category);
	}
	public int updateCategory(CategoryVO category) {
		return categoryMapper.updateCategory(category);
	}
	public int deleteCategory(int ciNum) {
		return categoryMapper.deleteCategory(ciNum);
	}
}