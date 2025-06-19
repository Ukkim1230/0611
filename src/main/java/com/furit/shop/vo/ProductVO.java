package com.furit.shop.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductVO {
	private int piNum;
	private int priRate;
	private String piName;
	private String piDesc;
	private int piPrice;
	private String piUnit;
	private String piImgPath;
	private MultipartFile piImg;
	private String piDesc2;
	private int ciNum;
	private String ciName;
	private String ciDesc;
	private String credat;
	private String cretim;
	private String lmodat;
	private String lmotim;
}