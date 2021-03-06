/**
 * 
 */
package com.zworks.musictag.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @Description:
 * @author zhangqiang
 * @date 2016年3月3日下午11:24:08
 *
 */
@Entity
@Table(name = "user")
public class User {
	@Id
	private String id;
	private String loginName;
	private String userName;
	private String password;
	private String salt;
	private String registerDate;
	private int sex;
	private String birthday;
	private String introduction;
	private String avatarUrl;
	private String userType;
	private String province;
	private String city;
	private String email;
	private String phone;
	@Transient
	private String plainPassword;

	public static final String ID = "id";
	public static final String LOGINNAME = "loginName";
	public static final String USERNAME = "userName";
	public static final String PASSWORD = "password";
	public static final String SALT = "salt";
	public static final String REGISTERDATE = "registerDate";
	public static final String SEX = "sex";
	public static final String BIRTHDAY = "birthday";
	public static final String INTRODUCTION = "introduction";
	public static final String AVATARURL = "avatarUrl";
	public static final String USERTYPE = "userType";
	public static final String PROVINCE = "province";
	public static final String CITY = "city";
	public static final String EMAIL = "email";
	public static final String PHONE = "phone";
	public static final String PLAINPASSWORD = "plainPassword";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

}
