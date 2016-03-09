package com.zworks.musictag.utils;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 * @date 2016年3月9日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
public class ValidatorResultHandler {

	public static JsonResponse handle(BindingResult result) {
		JsonResponse json = new JsonResponse();
		if (result.hasErrors()) {
			json.setStatus(JsonResponse.FAILED);
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				FieldError fieldError = (FieldError) error;
				json.put(Constants.ERRORPREFIX + fieldError.getField(), fieldError.getDefaultMessage());
			}
		}
		return json;
	}
}
