package com.furit.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furit.shop.mapper.CategoryMapper;
import com.furit.shop.vo.CategoryVO;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryMapper caMapper;
	
	public List<CategoryVO> selectCategoryList(CategoryVO category){
		return caMapper.selectCategoryList(category);
	}
	public int insertCategory(CategoryVO cateogry) {
		return caMapper.insertCategory(cateogry);
	}
	public int updateCategory(CategoryVO cateogry) {
		return caMapper.updateCategory(cateogry);
	}
	public int deleteCategory(int ciNum) {
		return caMapper.deleteCategory(ciNum);
	}
}
