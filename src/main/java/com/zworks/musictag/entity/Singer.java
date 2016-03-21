package com.zworks.musictag.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "singer")
public class Singer extends IdEntity {
	private String singerName;
	private String alias;
	private String birthday;
	private int sex;
	private String pkCountry;
	private String detail;

	public static final String SINGERNAME = "singerName";
	public static final String ALIAS = "alias";
	public static final String BIRTHDAY = "birthday";
	public static final String SEX = "sex";
	public static final String PKCOUNTRY = "pkCountry";
	public static final String DETAIL = "detail";

	public Singer() {

	}

	public Singer(long id) {
		this.id = id;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPkCountry() {
		return pkCountry;
	}

	public void setPkCountry(String pkCountry) {
		this.pkCountry = pkCountry;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
