package com.hb.major.controller;

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

import com.hb.major.model.entity.UserVo;
import com.hb.major.model.user.UserDaoImpl;


@Controller
public class HomeController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   UserVo bean;
   
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale) {
      logger.info("The client locale is {}.", locale);

      return "main";
   }
   
   
   
   //@RequestMapping(value = "/afterlogin/{kkoid}", method = RequestMethod.POST)
   //public String login(@PathVariable("kkoid") String kkoid, Model model, HttpServletRequest req) throws Exception {
	 
   
   @RequestMapping(value = "/", method = RequestMethod.POST) //포스트 방식으로들어오면 로그인
   public String login(Model model, HttpServletRequest req) throws Exception {

		req.setCharacterEncoding("UTF-8");

		
		System.out.println(req.getParameter("kakao_id"));
		System.out.println(req.getParameter("kakao_nick"));
		
		int id = Integer.parseInt(req.getParameter("kakao_id").substring(1, 7));
		String nickname = req.getParameter("kakao_nick");
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
//		디버깅 중 아직 안됨
//		bean.setNum(1);
//		bean.setId(id);
//		bean.setNickname(nickname);
//		System.out.println(bean);
//		
//		userDaoImpl.userInsertOne(bean);
		
		//return "loginoutdel/logout";
		return "main";
   }
   
   
   
	@RequestMapping(value="/deleteaccount", method=RequestMethod.POST)
	public String unlink() {
		//db에서 아이디 삭제해야하니까 post방식으로
		
		return "loginoutdel/deleteaccount"; //사실 여기 리다이렉트줘야하지 않나 싶은....
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

	
   
   
   
   
   
}