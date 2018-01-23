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

	
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(Locale locale, @ModelAttribute UserVo bean, HttpServletRequest req) {
		logger.info("The client locale is {}.", locale);
		System.out.println("����Ʈ����");
		
		bean.setKakao_id(req.getParameter("kakao_id"));
		bean.setKakao_nick(req.getParameter("kakao_nick"));
		bean.setProfile_img(req.getParameter("kakao_profile_image"));
		bean.setThumb_img(req.getParameter("kakao_thumbnail_image"));
		
		System.out.println(bean);
		
		
		return "main";
	}
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale) {
		logger.info("The client locale is {}.", locale);
		System.out.println("�ٸ���");
		return "main";
	}
	@RequestMapping(value="/deleteaccount", method=RequestMethod.POST)
	public String unlink() {
		//db���� ���̵� �����ؾ��ϴϱ� post�������
				
		return "loginoutdel/deleteaccount";  //��� ���� �����̷�Ʈ������� �ʳ� ����....
	}

	
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String boardfirstview(Locale locale, Model model) {
		
		logger.info("�Խ���", locale);
		bbsService.bbsListAll(model);
		
		return "user/board";
	}
	
	
	@RequestMapping(value = "/board/{bbspage}", method = RequestMethod.GET)
	public String board(Locale locale, Model model, @PathVariable("bbspage") int bbspage) {
		
		logger.info("�Խ���", locale);
		System.out.println("�Խ��� �������� "+bbspage);
		bbsService.bbsListAll(model);
		
		return "user/board";
	}
	
	@RequestMapping(value = "/detail/{postno}", method = RequestMethod.GET)
	public String detail(Locale locale, Model model, @PathVariable("postno") int postno) {
		
		logger.info("�Խñ� �� ������", locale);
		
		bbsService.bbsDetailOne(postno, model);
		
		return "user/detail";
	}

	@RequestMapping(value = "/edit/{postno}", method = RequestMethod.GET)
	public String editpage(Locale locale, Model model, @PathVariable("postno") int postno) {
		
		logger.info("�Խñ� ���� ������", locale);
		bbsService.bbsDetailOne(postno, model);
		
		return "user/edit";
	}
   @RequestMapping(value = "/edit/{postno}", method = RequestMethod.PUT)
	public String edit( @PathVariable("postno") int postno, BbsVo bean, Locale locale) throws Exception {
		bbsService.bbsUpdateOne(bean);
		System.out.println(bean);
		return "redirect:/board";
	}
   @RequestMapping(value = "/detail/{postno}", method = RequestMethod.DELETE)
   public String delete( @PathVariable("postno") int postno, BbsVo bean, Locale locale) throws Exception {
	   bbsService.bbsDeleteOne(postno);
	   
	   System.out.println(bean);
	   return "redirect:/board";
   }
   
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Locale locale, Model model) {
		logger.info("�Խñ� �ۼ�������", locale);
		System.out.println("add �� ����");
		return "user/write";
	}

	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String writeadd(Locale locale, @ModelAttribute BbsVo bean, HttpServletRequest req) {
		
		System.out.println("file encoding : " + System.getProperty("file.encoding"));
			
		
		String originalStr = bean.getContent();
		String [] charSet = {"utf-8","euc-kr","ksc5601","iso-8859-1","x-windows-949"};
		  
		for (int i=0; i<charSet.length; i++) {
		 for (int j=0; j<charSet.length; j++) {
		  try {
		   System.out.println("[" + charSet[i] +"," + charSet[j] +"] = " + new String(originalStr.getBytes(charSet[i]), charSet[j]));
		  } catch (UnsupportedEncodingException e) {
		   e.printStackTrace();
		  }
		 }
		}
		
		
		try {

		

		logger.info("�Խñ� �ۼ�", locale);
		System.out.println("add ����Ʈ ����");
		
	
		System.out.println(bean);
		System.out.println(bean.getNickName());
		//bean.setNickName("�ϴ� �׽�Ʈ");
		bbsService.bbsAddOne(bean);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/";
	}
	
	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
	   public String aboutus(Locale locale, Model model) throws Exception {
		   logger.info("ABOUT US", locale);
		   
		   return "user/aboutus";
	   }
	   @RequestMapping(value = "/notice", method = RequestMethod.GET)
	   public String notice(Locale locale, Model model) throws Exception {
		   logger.info("��������", locale);
		   
		   return "user/notice";
	   }
	   @RequestMapping(value = "/question", method = RequestMethod.GET)
	   public String complaint(Locale locale, Model model) throws Exception {
		   logger.info("���ǻ���", locale);
		   
		   return "user/question";
	   }

//	@RequestMapping(value = "/afterlogin/{kkoid}", method = RequestMethod.POST)
//	public String login(@PathVariable("kkoid") String kkoid, @ModelAttribute UserVo bean, HttpServletRequest req) throws Exception {
//
//		req.setCharacterEncoding("UTF-8");
//
//		bean.setKakao_id(req.getParameter("kakao_id"));
//		bean.setKakao_nick(req.getParameter("kakao_nick"));
//		bean.setProfile_img(req.getParameter("kakao_profile_image"));
//		bean.setThumb_img(req.getParameter("kakao_thumbnail_image"));
//		System.out.println(bean);
//		
////		userService.userInsertOne(bean);
////		System.out.println("�Է�");
//		
//		return "afterlogin";
//	}

}