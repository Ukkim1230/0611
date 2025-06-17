package com.furit.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.furit.shop.service.UserInfoService;
import com.furit.shop.vo.UserInfoVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserInfoController {
	@Autowired
	private UserInfoService uiService;
	
	@GetMapping("/users")
	public List<UserInfoVO> selectUserInfoList(UserInfoVO user){
		return uiService.selectUserInfoList(user);
	}
	@GetMapping("/users/{uiNum}")
	public UserInfoVO selectUserInfo(int uiNum) {
		return uiService.selectUserInfo(uiNum);
	}
	@PostMapping("/users/join")
	public UserInfoVO insertUserInfo(UserInfoVO user) { //form방식은 modelAttribute
		return uiService.insertUser(user);
	}
	@PostMapping("/users/login")
	public UserInfoVO login(@RequestBody UserInfoVO user, HttpSession session) { //application/json
		return uiService.login(user, session);
	}
	@PutMapping("/users")
	public int updateUserInfo(UserInfoVO user) {
		return uiService.updateUser(user);
	}
	@DeleteMapping("/users/{uiNum}")
	public int deleteUserInfo(int uiNum) {
		return uiService.deleteUser(uiNum);
	}

}
