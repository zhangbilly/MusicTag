package com.zworks.musictag.web.controller.account;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zworks.musictag.entity.User;
import com.zworks.musictag.service.AccountService;
import com.zworks.musictag.utils.JsonResponse;
import com.zworks.musictag.utils.ValidatorResultHandler;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody JsonResponse register(@Valid User user, BindingResult result) {
		JsonResponse json = ValidatorResultHandler.handle(result);
		if (json.isfailed()) {
			return json;
		}
		accountService.checkUnique(user, json);
		if (json.isfailed()) {
			return json;
		}
		accountService.registerUser(user);

		json.successWithData("url", "/login");
		json.put(User.ID, user.getId());
		return json;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String registerForm() {
		return "account/register";
	}
}
