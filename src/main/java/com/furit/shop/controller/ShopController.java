package com.furit.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.furit.shop.service.ProductService;
import com.furit.shop.vo.ProductVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ShopController {
	@Autowired
	private ProductService pdService;

	@GetMapping("/shop-detail")
	public String goShopDetail(@RequestParam("piNum") int piNum, Model m) {
		log.info("piNum=>{}", piNum);
		ProductVO product = pdService.selectProduct(piNum);
		m.addAttribute("product",product);
		return "views/shop-detail";
	}
}
