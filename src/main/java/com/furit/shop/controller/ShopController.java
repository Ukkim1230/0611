package com.furit.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.furit.shop.service.CategoryService;
import com.furit.shop.service.ProductReplyService;
import com.furit.shop.service.ProductService;
import com.furit.shop.vo.ProductReplyVO;
import com.furit.shop.vo.ProductVO;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ShopController {
	@Autowired
	private ProductService pdService;
	@Autowired
	private ProductReplyService productReplyService;
	@Autowired
	private CategoryService categoryService;
	@GetMapping("/shop-detail")
	public String goShopDetail(Model m, @ModelAttribute ProductReplyVO productReply) {
		m.addAttribute("product",pdService.selectProduct(productReply.getPiNum()));
		m.addAttribute("productReplys",productReplyService.selectProductReplyList(productReply));
		m.addAttribute("categories",categoryService.selectCategoryList(null));
		return "views/shop-detail";
	}
	@GetMapping("/shops")
	public String goShop(Model m, @ModelAttribute ProductVO product) {
		m.addAttribute("products",pdService.selectProductList2(product));
		m.addAttribute("categories",categoryService.selectCategoryList(null));
		return "views/shop";
	}
	@GetMapping("/shops2")
	public String goShop2(Model m , @ModelAttribute ProductVO product) {
		m.addAttribute("products",pdService.selectProductList2(product));
		m.addAttribute("categories",categoryService.selectCategoryList(null));
		return "views/product/shop2";
	}
	@GetMapping("/ajax-shop")
	@ResponseBody
	public PageInfo<ProductVO> getProductList(@ModelAttribute ProductVO product) {
		return pdService.selectProductList2(product);
	}
}
