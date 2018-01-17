package com.hb.major.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.hb.major.model.entity.BbsVo;
import com.hb.major.model.entity.UserVo;
import com.hb.major.service.bbs.BbsService;
import com.hb.major.service.user.UserService;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired private UserService userService;
	@Autowired private BbsService bbsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale) {
		logger.info("The client locale is {}.", locale);

		return "main";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(@ModelAttribute UserVo bean, HttpServletRequest req) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		
		if(!(req.getParameter("kakao_id").equals(bean.getKakao_id()))) {
			// kakao_id PK라 동일한 값이 들어오면 원래 입력은 안됨..
			bean.setKakao_id(req.getParameter("kakao_id"));
			bean.setKakao_nick(req.getParameter("kakao_nick"));
			bean.setKakao_profile_image(req.getParameter("kakao_profile_image"));
			bean.setKakao_thumbnail_image(req.getParameter("kakao_thumbnail_image"));
			userService.userInsertOne(bean);
			System.out.println(bean);
			System.out.println("입력");
		} else {
			System.out.println("아이디 있으니께 메인으로 리턴");
			return "main";
		}
		return "main";
	}
	
	@RequestMapping(value="/deleteaccount", method=RequestMethod.POST)
	public String unlink() {
		//db에서 아이디 삭제해야하니까 post방식으로
				
		return "loginoutdel/deleteaccount";  //사실 여기 리다이렉트줘야하지 않나 싶은....
	}

	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Locale locale, Model model) {
		
		logger.info("게시판", locale);
		
		bbsService.bbsListAll(model);
		
		return "user/board";
	}
	
	@RequestMapping(value = "/detail/{idx}", method = RequestMethod.GET)
	public String detail(@PathVariable("idx") int no, Locale locale, Model model) {
		
		model.addAttribute("title", "내용보기");
		
		bbsService.bbsDetailOne(no, model);
		
		return "user/detail";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("idx") int no, Model model) throws Exception {
		model.addAttribute("title", "게시글 수정");
		
		return "user/detail";
	}
	
   @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
  	public String aboutus(Locale locale, Model model) throws Exception {
  		logger.info("ABOUT US", locale);
  		
  		return "user/aboutus";
  	}
   
   @RequestMapping(value = "/notice", method = RequestMethod.GET)
 	public String notice(Locale locale, Model model) throws Exception {
 		logger.info("공지사항", locale);
 		
 		return "user/notice";
 	}
   @RequestMapping(value = "/question", method = RequestMethod.GET)
 	public String complaint(Locale locale, Model model) throws Exception {
 		logger.info("문의사항", locale);
 		
 		return "user/question";
 	}
   
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Locale locale, Model model) {
		logger.info("글쓰기페이지", locale);
		
		
		return "user/write";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public String writeadd(@ModelAttribute BbsVo bean, HttpServletRequest req, Locale locale) {
		logger.info("게시글 작성완료", locale);
		bbsService.bbsAddOne(bean);
		
		return "redirect:/board";
	}


}