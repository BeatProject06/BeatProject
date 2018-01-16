package com.hb.major.controller;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.annotation.Resource;
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
import com.hb.major.model.entity.UserVo;
import com.hb.major.service.bbs.BbsService;
import com.hb.major.service.user.UserService;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//	@Autowired private UserService userService;
	
	@Autowired private BbsService bbsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale) {
		logger.info("The client locale is {}.", locale);

		return "home";
	}

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Locale locale, Model model) {
		
		logger.info("�Խ���", locale);
		
		bbsService.bbsListAll(model);
		
		return "user/board";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Locale locale, Model model, int no) {
		
		logger.info("�Խñ� �� ������", locale);
		
		bbsService.bbsDetailOne(no, model);
		
		return "user/detail";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Locale locale, Model model) {
		logger.info("�Խñ� �ۼ�������", locale);

		return "user/write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writeadd(Locale locale, @ModelAttribute BbsVo bean, HttpServletRequest req) {
		
		logger.info("�Խñ� �ۼ�", locale);
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bbsService.bbsAddOne(bean);
		System.out.println(bean);
		
		return "redirect:/board";
	}

	@RequestMapping(value = "/afterlogin/{kkoid}", method = RequestMethod.POST)
	public String login(@PathVariable("kkoid") String kkoid, @ModelAttribute UserVo bean, HttpServletRequest req) throws Exception {

		req.setCharacterEncoding("UTF-8");

		bean.setKakao_id(req.getParameter("kakao_id"));
		bean.setKakao_nick(req.getParameter("kakao_nick"));
		bean.setProfile_img(req.getParameter("kakao_profile_image"));
		bean.setThumb_img(req.getParameter("kakao_thumbnail_image"));
		System.out.println(bean);
		
//		userService.userInsertOne(bean);
//		System.out.println("�Է�");
		
		return "afterlogin";
	}

}