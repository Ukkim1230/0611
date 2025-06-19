package com.furit.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furit.shop.mapper.UserInfoMapper;
import com.furit.shop.util.FileUtils;
import com.furit.shop.util.SHA256Utils;
import com.furit.shop.util.SessionUtils;
import com.furit.shop.vo.UserInfoVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserInfoService {
	@Autowired
	private UserInfoMapper uiMapper;
	private final FileUtils fileUtil;
	
	public List<UserInfoVO> selectUserInfoList(UserInfoVO user){
		return uiMapper.selectUserInfoList(user);
	}
	public UserInfoVO selectUserInfo(int uiNum) {
		return uiMapper.selectUserInfo(uiNum);
	}
	public UserInfoVO login(UserInfoVO user, HttpSession session){
		UserInfoVO dbUser = uiMapper.selectUserInfoById(user.getUiId());
		String uiPwd = user.getUiPwd();
		uiPwd = SHA256Utils.encodePwd(uiPwd);
		
		if(!uiPwd.equals(dbUser.getUiPwd())){
			throw new RuntimeException("아이디 비밀번호를 확인하세요");
		}
		dbUser.setUiPwd(null);
		session.setAttribute("user", dbUser);
		return dbUser;
	}
	public UserInfoVO insertUser(UserInfoVO user) {
		String uiPwd = user.getUiPwd();
		uiPwd = SHA256Utils.encodePwd(uiPwd);
		user.setUiPwd(uiPwd);
		String uiProfileImg = fileUtil.saveFile(user.getUiProfile(), "profile");
		user.setUiProfileImg(uiProfileImg);
		uiMapper.insertUserInfo(user);
		user.setUiProfile(null);
		return user;
	}
	public int updateUser(UserInfoVO user,HttpSession session) {
		String uiProfileImg = fileUtil.saveFile(user.getUiProfile(), "profile");
		user.setUiProfileImg(uiProfileImg);
		uiMapper.updateUserInfo(user);
		UserInfoVO dbUser = uiMapper.selectUserInfoById(user.getUiId());
		session.setAttribute("user", dbUser);
		return uiMapper.updateUserInfo(user);
	}
	public int deleteUser(int uiNum) {
		return uiMapper.deleteUserInfo(uiNum);
	}
	

}
