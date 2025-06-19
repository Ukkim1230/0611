package com.furit.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.furit.shop.mapper.CartHistoryMapper;
import com.furit.shop.vo.CartHistoryVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartHistoryService {
	private final CartHistoryMapper chMapper;

	public List<CartHistoryVO> selectCartHistoryList(CartHistoryVO cart) {
		return chMapper.selectCartHistoryList(cart);
	}
	public CartHistoryVO selectCartHistory(int chiNum) {
		return chMapper.selectCartHistory(chiNum);
	}
	public int insertCartHistory(CartHistoryVO cart) {
		int cnt = chMapper.selectCartHistoryByUiNumAndPiNum(cart);
			if(cart.getChiQty()==0) {
				cart.setChiQty(1);
			}
			if(cnt!=0) {
					return chMapper.updateCartHistoryChiQty(cart);
			}
			return chMapper.insertCartHistory(cart);
	}
	public int updateCartHistory(CartHistoryVO cart) {
		return chMapper.updateCartHistory(cart);
	}
	public int deleteCartHistory(int chiNum) {
		return chMapper.deleteCartHistory(chiNum);
	}
}
