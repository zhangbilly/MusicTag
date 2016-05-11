package com.zworks.musictag.web.controller.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zworks.musictag.entity.Comment;
import com.zworks.musictag.entity.enumerate.CommentType;
import com.zworks.musictag.service.CommentService;
import com.zworks.musictag.utils.CommentTypeConverter;
import com.zworks.musictag.utils.JsonResponse;

/**
 * @date 2016年5月11日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Controller
@RequestMapping(value = "comment")
public class CommentController {
	@Autowired
	private CommentService commentService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody JsonResponse addComment(@RequestBody Comment comment, BindingResult result) {
		JsonResponse json = new JsonResponse();
		comment = commentService.save(comment);
		json.successWithData("comment", comment);
		return json;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(CommentType.class, new CommentTypeConverter());
	}

	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) {
	 * binder.registerCustomEditor(CommentType.class, new
	 * CaseInsensitiveConverter<>(CommentType.class)); }
	 */

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public @ResponseBody JsonResponse getLatestComment(@RequestParam(value = "pn", defaultValue = "1") int pageNumber,
			@RequestParam(value = "ps", defaultValue = "20") int pageSize, @RequestParam String resourceId,
			@RequestParam CommentType type) {
		JsonResponse json = new JsonResponse();
		Page<Comment> commentList = commentService.getLatestComment(pageNumber, pageSize, resourceId, type);
		json.successWithData("comments", commentList);
		return json;
	}
}
