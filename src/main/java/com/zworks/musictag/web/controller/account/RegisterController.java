package com.zworks.musictag.web.controller.account;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zworks.musictag.entity.User;
import com.zworks.musictag.service.AccountService;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.POST)
	public String register(@Valid User user, RedirectAttributes redirectAttributes) {
		accountService.registerUser(user);
		redirectAttributes.addFlashAttribute(User.LOGINNAME, user.getLoginName());
		return "redirect:account/login";
	}
}
