package com.furit.shop.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA256Utils {
	private static final String SALT = "123456789123456789123456789123456789";
	
	public static String encodePwd(String uiPwd) {
		return DigestUtils.sha1Hex(uiPwd + SALT);
	}
	
	public static void main(String[] args) {
	String uiPwd = "1234";
	String encodePwd = DigestUtils.sha256Hex(uiPwd + SALT); //복호화 안됨
	//모든 암호화가 동일하게 일어남.
	//sha256래인보우테이블(sha256비번알아내는사이트)=SALT를 사용하는 이유
	System.out.println(encodePwd);
	}
}
