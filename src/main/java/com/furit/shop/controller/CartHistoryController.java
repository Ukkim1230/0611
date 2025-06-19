package com.furit.shop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.furit.shop.service.CartHistoryService;
import com.furit.shop.vo.CartHistoryVO;
import com.furit.shop.vo.UserInfoVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CartHistoryController {
	private final CartHistoryService chService;
	
	@GetMapping("/carts")
	public List<CartHistoryVO> selectCartHistoryList(CartHistoryVO cart, HttpSession session){
		UserInfoVO user = (UserInfoVO)session.getAttribute("user");
		if(user!=null) {
			cart.setUiNum(user.getUiNum());
		}
		return chService.selectCartHistoryList(cart);
	}
	@GetMapping("/carts/{chiNum}")
	public CartHistoryVO selectCartHistory(@PathVariable("chiNum") int chiNum) {
		return chService.selectCartHistory(chiNum);
	}
	@PostMapping("/carts")
	public int insertCartHistory(@RequestBody CartHistoryVO cart, HttpSession session) {
		UserInfoVO user = (UserInfoVO)session.getAttribute("user");
		cart.setUiNum(user.getUiNum());
		return chService.insertCartHistory(cart);
	}
	@PutMapping("/carts")
	public int updateCartHistory(CartHistoryVO cart) {
		return chService.updateCartHistory(cart);
	}
	@DeleteMapping("/carts")
	public int deleteCartHistory(int chiNum) {
		return chService.deleteCartHistory(chiNum);
	}
}