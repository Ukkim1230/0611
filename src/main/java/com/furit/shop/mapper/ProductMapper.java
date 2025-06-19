package com.furit.shop.mapper;

import java.util.List;

import com.furit.shop.vo.ProductVO;

public interface ProductMapper {
	
	List<ProductVO> selectProductList(ProductVO product);
	ProductVO selectProduct(int piNum);
	int insertProduct(ProductVO product);
	int updateProduct(ProductVO product);
	int deleteProduct(int piNum);

}
