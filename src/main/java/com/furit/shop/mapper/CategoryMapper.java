package com.furit.shop.mapper;

import java.util.List;

import com.furit.shop.vo.CategoryVO;

public interface CategoryMapper {
	List<CategoryVO> selectCategoryList(CategoryVO category);
	int insertCategory(CategoryVO cateogry);
	int updateCategory(CategoryVO cateogry);
	int deleteCategory(int ciNum);
}
