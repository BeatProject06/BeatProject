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
	public String home(Locale locale, Model menumodel) {
		logger.info("The client locale is {}.", locale);
		menumodel.addAttribute("currentmenu", "home");
		
		return "main";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(@ModelAttribute UserVo bean, HttpServletRequest req, Model menumodel) throws Exception {

		req.setCharacterEncoding("UTF-8");
		
		menumodel.addAttribute("currentmenu", "home");
		userService.userCheck(bean);
		
		// kakao_id PK라 동일한 값이 들어오면 원래 입력은 안됨..
/*		String id = req.getParameter("kakao_id");
		String nick = req.getParameter("kakao_nick");
		String profile = req.getParameter("kakao_profile_image");
		String thumb = req.getParameter("kakao_thumbnail_image");
		
		userService.userInsertOne(bean);
		System.out.println("유저정보 입력 : "+bean);
		// 정보 조회 하는데 흐음..
		
		if(!id.equals(bean.getKakao_id())) {
			// 뷰에서 받아온 id값과 db id 값을 비교 했을 때 없으면 입력
			userService.userSelectOne(id);
			bean.setKakao_id(req.getParameter("kakao_id"));
			bean.setKakao_nick(req.getParameter("kakao_nick"));
			bean.setKakao_profile_image(req.getParameter("kakao_profile_image"));
			bean.setKakao_thumbnail_image(req.getParameter("kakao_thumbnail_image"));
			userService.userInsertOne(bean);
			System.out.println("유저정보 입력 : "+bean);
			
		} else if(!nick.equals(bean.getKakao_nick()) || !profile.equals(bean.getKakao_profile_image()) || !thumb.equals(bean.getKakao_thumbnail_image())) {
			// 닉네임, 프로필 이미지, 섬네일 중 다른게 하나 있다면 업데이트
//			userService.userSelectOne(id);
			bean.setKakao_id(id);
			userService.userUpdateOne(bean);
			System.out.println("유저정보 업데이트 : "+bean);
		} else {
			return "main";
		}*/
		
		return "main";
	}

	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
	public String aboutus(Locale locale, Model model) throws Exception {
		logger.info("ABOUT US", locale);
		
		model.addAttribute("currentmenu", "aboutus");
		return "user/aboutus";
	}


}