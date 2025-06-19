package com.furit.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.furit.shop.mapper.ProductReplyMapper;
import com.furit.shop.vo.ProductReplyVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductReplyService {
	private final ProductReplyMapper prMapper;
	
	public List<ProductReplyVO> selectProductReplyList(ProductReplyVO product){
		return prMapper.selectProductReplyList(product);
	}
	public ProductReplyVO selectProductReply(int priNum) {
		return prMapper.selectProductReply(priNum);
	}
	public int insertProductReply (ProductReplyVO product) {
		return prMapper.insertProductReply(product);
	}
	public int updateProductReply (ProductReplyVO product) {
		return prMapper.updateProductReply(product);
	}
	public int deleteProductReply (int priNum) {
		return prMapper.deleteProductReply(priNum);
	}
}
