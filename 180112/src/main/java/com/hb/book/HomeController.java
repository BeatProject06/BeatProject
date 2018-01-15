package com.hb.book;


import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		return "home";
	}
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Locale locale, Model model) {
		logger.info("게시판", locale);
		
		
		return "user/board";
	}
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Locale locale, Model model) {
		logger.info("게시글 작성페이지", locale);
		
		
		return "user/write";
	}
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writeadd(Locale locale, Model model) {
		logger.info("게시글 작성", locale);
		
		
		return "redirect:/board";
	}
	
	@RequestMapping(value = "/afterlogin/{kkoid}", method = RequestMethod.POST)
	   public String login(@PathVariable("kkoid") String kkoid, Locale locale, Model model, HttpServletRequest req) {
	      logger.info("The client locale is {}.", locale);
	      try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      System.out.println(req.getParameter("kakao_id"));
	      System.out.println(req.getParameter("kakao_nick"));


	      return "afterlogin";
	   }

}
