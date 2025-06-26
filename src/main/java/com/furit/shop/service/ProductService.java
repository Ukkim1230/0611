package com.furit.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furit.shop.mapper.ProductMapper;
import com.furit.shop.util.FileUtils;
import com.furit.shop.vo.ProductVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ProductService {

	@Autowired
	private ProductMapper ProductMapper;
	@Autowired
	private FileUtils fileUtil;
	
	public List<ProductVO> selectProductList(ProductVO product){
		return ProductMapper.selectProductList(product);
	}
	public PageInfo<ProductVO> selectProductList2(ProductVO product){
		int pageNum = product.getPageNum()==0?1:product.getPageNum();
		int rowNum = product.getRowNum()==0?3:product.getRowNum();
		product.setRowNum(rowNum);
		PageHelper.startPage(pageNum,rowNum);
		return PageInfo.of(ProductMapper.selectProductList2(product));
	}
	public ProductVO selectProduct(int piNum){
		return ProductMapper.selectProduct(piNum);
	}
	public int insertProduct(ProductVO product) {
		product.setPiImgPath(fileUtil.saveFile(product.getPiImg(), "product"));
		return ProductMapper.insertProduct(product);
	}
	public int updateProduct(ProductVO product) {
		product.setPiImgPath(fileUtil.saveFile(product.getPiImg(), "product"));
		return ProductMapper.updateProduct(product);
	}
	public int deleteProduct(int ciNum) {
		return ProductMapper.deleteProduct(ciNum);
	}
}