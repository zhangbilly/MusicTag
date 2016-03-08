package com.zworks.musictag.data;

import org.springside.modules.test.data.RandomData;

import com.zworks.musictag.entity.User;

public class UserData {
	public static User randomNewUser() {
		User user = new User();
		user.setLoginName(RandomData.randomName("user"));
		user.setUserName(RandomData.randomName("UserName"));
		user.setPlainPassword(RandomData.randomName("password"));
		return user;
	}
}
