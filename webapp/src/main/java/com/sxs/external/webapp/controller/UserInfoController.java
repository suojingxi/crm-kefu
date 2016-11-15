package com.sxs.external.webapp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxs.external.dao.mapper.ManagerUserInfoMapper;
import com.sxs.external.dao.mapper.UserInfoMapper;
import com.sxs.external.dao.model.ManagerUserInfo;
import com.sxs.external.dao.model.UserInfo;

@RestController
@RequestMapping(value = "/user")
public class UserInfoController {

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private ManagerUserInfoMapper managerUserInfoMapper;

	@RequestMapping(value = "/getUserInfoList")
	public List<UserInfo> getUserInfoList(HttpServletRequest request, 
			HttpServletResponse response, ModelMap modelMap) {
		return userInfoMapper.selectUserInfoList();
	}

	@RequestMapping(value = "/getUserInfoById")
    public Map<String, Object> getUserInfoById(HttpServletRequest request,
            HttpServletResponse response, ModelMap modelMap, String id) {
        if (StringUtils.isNotBlank(id)) {
            return userInfoMapper.getUserInfoById(Integer.parseInt(id));
        } 
        return null;
    }

	@RequestMapping(value = "/editUserInfo")
	public String editUserInfo(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,
			UserInfo userInfo) {
		if (userInfo != null) {
			if (userInfo.getId() != null) {
				userInfoMapper.updateUserInfo(userInfo);
			} else {
				userInfoMapper.insertUserInfo(userInfo);
			}
			return "success";
		}
		return "error";
	}

	@RequestMapping(value = "/deleteUserInfoById")
	public String deleteUserInfoById(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,
			String id) {
		if (StringUtils.isNotBlank(id)) {
			userInfoMapper.deleteUserInfoById(Integer.parseInt(id));
			return "success";
		}
		return "error";
	}
	
	@RequestMapping(value="/managerUserInfoList")
	public List<ManagerUserInfo> managerUserInfoList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
		return managerUserInfoMapper.getList();
	}
}
