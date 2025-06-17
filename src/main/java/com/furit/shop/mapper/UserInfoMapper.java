package com.furit.shop.mapper;

import java.util.List;

import com.furit.shop.vo.UserInfoVO;

public interface UserInfoMapper {
	
	List<UserInfoVO> selectUserInfoList(UserInfoVO user);
	UserInfoVO selectUserInfo(int uiNum);
	UserInfoVO selectUserInfoById(String uiId);
	int insertUserInfo (UserInfoVO user);
	int updateUserInfo (UserInfoVO user);
	int deleteUserInfo (int uiNum);
}
