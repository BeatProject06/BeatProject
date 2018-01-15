package com.hb.major.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hb.major.model.entity.UserVo;
import com.hb.major.model.user.UserDaoImpl;
import com.hb.major.service.user.UserServiceImpl;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale) {
		logger.info("The client locale is {}.", locale);

		return "home";
	}

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Locale locale, Model model) {
		logger.info("�Խ���", locale);

		return "user/board";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Locale locale, Model model) {
		logger.info("�Խñ� �ۼ�������", locale);

		return "user/write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writeadd(Locale locale, Model model) {
		logger.info("�Խñ� �ۼ�", locale);

		return "redirect:/board";
	}

	@RequestMapping(value = "/afterlogin/{kkoid}", method = RequestMethod.POST)
	public String login(@PathVariable("kkoid") String kkoid, @ModelAttribute UserVo bean, HttpServletRequest req) throws Exception {

		req.setCharacterEncoding("UTF-8");

//		int id = Integer.parseInt(req.getParameter("kakao_id").substring(1, 9));
//		String nick = req.getParameter("kakao_nick");
//		System.out.println(id);
//		System.out.println(nick);
			
		bean.setKakao_id(req.getParameter("kakao_id"));
		bean.setKakao_nick(req.getParameter("kakao_nick"));
		bean.setProfile_img(req.getParameter("kakao_profile_image"));
		bean.setThumb_img(req.getParameter("kakao_thumbnail_image"));
		System.out.println(bean);
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.userInsertOne(bean);
		System.out.println("�Է�");
		
		return "afterlogin";
	}

}