package com.situ.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.EasyUIDataGrid;
import com.situ.crm.common.ServletResponse;
import com.situ.crm.pojo.SaleChance;
import com.situ.crm.pojo.User;
import com.situ.crm.service.IUserService;

@Controller
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="index")
	public String index () {
		return "user_manager";
	}
	
	@RequestMapping(value="pageList")
	@ResponseBody
	public EasyUIDataGrid pageList(Integer page, Integer rows, User user) {
		return userService.pageList(page, rows,user);
	}
	
	@RequestMapping(value="delete")
	@ResponseBody
	public ServletResponse deleteUser(String ids) {
		return userService.deleteUser(ids);
	}
	
	@RequestMapping(value="add")
	@ResponseBody
	public ServletResponse addUser (User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping(value="update")
	@ResponseBody
	public ServletResponse updateUser (User user) {
		return userService.updateUser(user);
	}
	@RequestMapping(value="isUser")
	@ResponseBody
	public ServletResponse isUser (String userName) {
		return userService.isUser(userName);
	}
	
	@RequestMapping(value="checkUserPassword")
	@ResponseBody
	public ServletResponse checkUserPassword(String name, String password) {
		return userService.checkUserPassword(name, password);
	}
	
	@RequestMapping(value="updatePassword")
	@ResponseBody
	public ServletResponse updatePassword (User user) {
		return userService.updatePassword(user);
	}
	
	@RequestMapping(value="getCustomerManagerList")
	@ResponseBody
	public List<User> getCustomerManagerList() {
		return userService.getCustomerManagerList();
	}
}
