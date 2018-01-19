package com.hb.major.controller;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hb.major.model.entity.BbsVo;
import com.hb.major.model.entity.CommentVo;
import com.hb.major.service.comment.CommentService;

@Controller
public class CommentController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/board/detail/writecomment", method = RequestMethod.POST)
	public String writecmt(Locale locale, @ModelAttribute CommentVo cmtbean, HttpServletRequest req) {
		
		logger.info("�ڸ�Ʈ�ۼ�", locale);
		System.out.println("�ڸ�Ʈ�ۼ� post����");
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		int boardNum = Integer.parseInt(req.getParameter("bbsNo"));
		System.out.println(boardNum);
		cmtbean.setBbsNo(boardNum);
		commentService.commentAddOne(cmtbean);
		System.out.println(cmtbean);

		return "redirect:/board/detail/"+cmtbean.getBbsNo();
	}
	
	
}
