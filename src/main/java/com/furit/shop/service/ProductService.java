package com.furit.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furit.shop.mapper.ProductMapper;
import com.furit.shop.util.FileUtils;
import com.furit.shop.vo.ProductVO;

@Service
public class ProductService {
	@Autowired
	private ProductMapper prMapper;
	@Autowired
	private FileUtils fileUtil;

	public List<ProductVO> selectProductList(ProductVO product){
		return prMapper.selectProductList(product);
	}
	public int insertProduct(ProductVO product) {
		product.setPiImgPath(fileUtil.saveFile(product.getPiImg(), "product"));
		return prMapper.insertProduct(product);
	}
	public int updateProduct(ProductVO product) {
		product.setPiImgPath(fileUtil.saveFile(product.getPiImg(), "product"));
		return prMapper.updateProduct(product);
	}
	public int deleteProduct(int piNum) {
		return prMapper.deleteProduct(piNum);
	}
}
