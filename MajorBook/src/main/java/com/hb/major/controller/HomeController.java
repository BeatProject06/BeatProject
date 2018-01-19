package com.hb.major.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hb.major.model.entity.UserVo;
import com.hb.major.service.user.UserService;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserService userService;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale) {
		logger.info("The client locale is {}.", locale);

		return "main";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(@ModelAttribute UserVo bean, HttpServletRequest req) throws Exception {

		req.setCharacterEncoding("UTF-8");

		// kakao_id PK라 동일한 값이 들어오면 원래 입력은 안됨..
		bean.setKakao_id(req.getParameter("kakao_id"));
		bean.setKakao_nick(req.getParameter("kakao_nick"));
		bean.setKakao_profile_image(req.getParameter("kakao_profile_image"));
		bean.setKakao_thumbnail_image(req.getParameter("kakao_thumbnail_image"));
		userService.userInsertOne(bean);
		System.out.println(bean);
		System.out.println("입력");
		
		return "main";
	}

	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
	public String aboutus(Locale locale, Model model) throws Exception {
		logger.info("ABOUT US", locale);

		return "user/aboutus";
	}


}