package com.hb.major.controller;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
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

import com.hb.major.model.bbs.BbsDao;
import com.hb.major.model.entity.BbsVo;
import com.hb.major.model.entity.UserVo;
import com.hb.major.model.user.UserDaoImpl;
import com.hb.major.service.bbs.BbsService;
import com.hb.major.service.user.UserService;


@Controller
public class HomeController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   BbsVo bean;
   @Autowired
   UserService userService;
   
   @Autowired private BbsService bbsService;
   
   
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale) {
      logger.info("The client locale is {}.", locale);

      return "main";
   }
   
   
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
	public String boardfirstview(Locale locale, Model model) {
		
		logger.info("게시판", locale);
		bbsService.bbsListAll(model);
		
		return "user/board";
	}
   
   @RequestMapping(value = "/board/{bbspage}", method = RequestMethod.GET)
	public String board(Locale locale, Model model, @PathVariable("bbspage") int bbspage) {
		
		logger.info("게시판", locale);
		System.out.println("게시판 페이지는 "+bbspage);
		bbsService.bbsListAll(model);
		
		return "user/board";
	}
	
   @RequestMapping(value = "/detail/{postno}", method = RequestMethod.GET)
	public String detail(Locale locale, Model model, @PathVariable("postno") int postno) {
		
		logger.info("게시글 상세 페이지", locale);
		bbsService.bbsDetailOne(postno, model);
		
		return "user/detail";
	}
   
   @RequestMapping(value = "/edit/{postno}", method = RequestMethod.GET)
	public String editpage(Locale locale, Model model, @PathVariable("postno") int postno) {
		
		logger.info("게시글 수정 페이지", locale);
		bbsService.bbsDetailOne(postno, model);
		
		return "user/edit";
	}
   @RequestMapping(value = "/edit/{postno}", method = RequestMethod.PUT)
	public String edit( @PathVariable("postno") int postno, BbsVo bean, Locale locale) throws Exception {
		bbsService.bbsUpdateOne(bean);
		
		return "redirect:/board";
	}
   @RequestMapping(value = "/detail/{postno}", method = RequestMethod.DELETE)
   public String delete( @PathVariable("postno") int postno, BbsVo bean, Locale locale) throws Exception {
	   bbsService.bbsDeleteOne(postno);
	   
	   System.out.println(bean);
	   return "redirect:/board";
   }
   @RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writeadd(Locale locale, @ModelAttribute BbsVo bean, HttpServletRequest req) {
		
		logger.info("게시글 작성", locale);
		System.out.println("add 포스트 들어옴");
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
	   logger.info("게시글 작성페이지", locale);
	   System.out.println("add 겟 들어옴");
	   return "user/write";
   }
   
//   @RequestMapping(value = "/afterlogin/{kkoid}", method = RequestMethod.POST)
//   public String login(@PathVariable("kkoid") String kkoid, Model model, HttpServletRequest req) throws Exception {
//
//		req.setCharacterEncoding("UTF-8");
//
//		System.out.println(req.getParameter("kakao_id"));
//		System.out.println(req.getParameter("kakao_nick"));
//		
//		int id = Integer.parseInt(req.getParameter("kakao_id").substring(1, 7));
//		String nickname = req.getParameter("kakao_nick");
//		
//		UserDaoImpl userDaoImpl = new UserDaoImpl();
////		디버깅 중 아직 안됨
////		bean.setNum(1);
////		bean.setId(id);
////		bean.setNickname(nickname);
////		System.out.println(bean);
////		
////		userDaoImpl.userInsertOne(bean);
//		
//		return "afterlogin";
//   }
   
   
   
   
}