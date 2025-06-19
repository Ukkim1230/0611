package com.furit.shop.mapper;

import java.util.List;

import com.furit.shop.vo.ProductReplyVO;

public interface ProductReplyMapper {
	
	List<ProductReplyVO> selectProductReplyList(ProductReplyVO product);
	ProductReplyVO selectProductReply(int priNum);
	int insertProductReply (ProductReplyVO product);
	int updateProductReply (ProductReplyVO product);
	int deleteProductReply (int priNum);
	
}
