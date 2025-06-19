package com.furit.shop.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartHistoryVO {
	private int chiNum;
	private int uiNum;
	private int piNum;
	private int chiQty;
	private String credat;
	private String cretim;
	private String lmodat;
	private String lmotim;
}
