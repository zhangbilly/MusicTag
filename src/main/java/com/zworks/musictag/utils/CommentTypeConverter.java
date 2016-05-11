package com.zworks.musictag.utils;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.text.WordUtils;

import com.zworks.musictag.entity.enumerate.CommentType;

/**
 * @date 2016年5月11日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
public class CommentTypeConverter extends PropertyEditorSupport {

	@Override
	public void setAsText(final String text) throws IllegalArgumentException {
		setValue(CommentType.valueOf(WordUtils.capitalize(text.trim())));
	}
}
