/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.zworks.musictag.web.controller.account;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zworks.musictag.utils.Constants;
import com.zworks.musictag.utils.JsonResponse;

/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)，
 * 
 * 真正登录的POST请求由Filter完成,
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String getLoginPage() {
		return "account/login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody JsonResponse login(HttpServletRequest request, Model model) {
		JsonResponse json = new JsonResponse();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		boolean rememberMe = new Boolean(request.getParameter("rememberme"));
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		token.setRememberMe(rememberMe);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			if (subject.isAuthenticated()) {
				json.successWithData(Constants.URL, "/index");
			} else {
				json.failed("认证失败");
			}
		} catch (IncorrectCredentialsException e) {
			return json.failedWithReturn("登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.");
		} catch (ExcessiveAttemptsException e) {
			return json.failedWithReturn("登录失败次数过多");
		} catch (LockedAccountException e) {
			return json.failedWithReturn("帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.");
		} catch (DisabledAccountException e) {
			return json.failedWithReturn("帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.");
		} catch (ExpiredCredentialsException e) {
			return json.failedWithReturn("帐号已过期. the account for username " + token.getPrincipal() + "  was expired.");
		} catch (UnknownAccountException e) {
			return json.failedWithReturn("帐号不存在. There is no user with username of " + token.getPrincipal());
		} catch (UnauthorizedException e) {
			return json.failedWithReturn("您没有得到相应的授权！" + e.getMessage());
		}
		return json;
	}

}
