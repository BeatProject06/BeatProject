package com.hb.major.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hb.major.model.entity.UserVo;
import com.hb.major.model.user.UserDaoImpl;


@Controller
public class HomeController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   UserVo bean;
   
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale) {
      logger.info("The client locale is {}.", locale);

      return "home";
   }
   
   
   
   
   @RequestMapping(value = "/afterlogin/{kkoid}", method = RequestMethod.POST)
   public String login(@PathVariable("kkoid") String kkoid, Model model, HttpServletRequest req) throws Exception {

		req.setCharacterEncoding("UTF-8");

		System.out.println(req.getParameter("kakao_id"));
		System.out.println(req.getParameter("kakao_nick"));
		
		int id = Integer.parseInt(req.getParameter("kakao_id").substring(1, 7));
		String nickname = req.getParameter("kakao_nick");
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
//		µð¹ö±ë Áß ¾ÆÁ÷ ¾ÈµÊ
//		bean.setNum(1);
//		bean.setId(id);
//		bean.setNickname(nickname);
//		System.out.println(bean);
//		
//		userDaoImpl.userInsertOne(bean);
		
		return "afterlogin";
   }
   
}