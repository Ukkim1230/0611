package com.furit.shop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.furit.shop.service.ProductReplyService;
import com.furit.shop.vo.ProductReplyVO;
import com.furit.shop.vo.UserInfoVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductReplyController {
	
private final ProductReplyService prService;
	@GetMapping("product-replies")
	public List<ProductReplyVO> selectProductReplyList(ProductReplyVO product){
		return prService.selectProductReplyList(product);
	}
	@GetMapping("product-replies/{priNum}")
	public ProductReplyVO selectProductReply(@PathVariable("priNum") int priNum) {
		return prService.selectProductReply(priNum);
	}
	@PostMapping("product-replies")
	public int insertProductReply (@RequestBody ProductReplyVO product, HttpSession session) {
		UserInfoVO user = (UserInfoVO)session.getAttribute("user");
		product.setUiNum(user.getUiNum());
		return prService.insertProductReply(product);
	}
	@PutMapping("product-replies")
	public int updateProductReply (ProductReplyVO product) {
		return prService.updateProductReply(product);
	}
	@DeleteMapping("product-replies/{priNum}")
	public int deleteProductReply (@PathVariable("priNum") int priNum) {
		return prService.deleteProductReply(priNum);
	}

}
