package com.furit.shop.mapper;

import java.util.List;

import com.furit.shop.vo.CartHistoryVO;

public interface CartHistoryMapper {
	
	List<CartHistoryVO> selectCartHistoryList(CartHistoryVO cart);
	CartHistoryVO selectCartHistory(int chiNum);
	int selectCartHistoryByUiNumAndPiNum(CartHistoryVO cart);
	int updateCartHistoryChiQty(CartHistoryVO cart);
	int insertCartHistory(CartHistoryVO cart);
	int updateCartHistory(CartHistoryVO cart);
	int deleteCartHistory(int chiNum);
}
