package com.hb.major.controller;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hb.major.model.entity.BbsVo;
import com.hb.major.model.entity.UserVo;
import com.hb.major.service.bbs.BbsService;
import com.hb.major.service.comment.CommentService;
import com.hb.major.service.user.UserService;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private BbsService bbsService;
	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale) {
		logger.info("The client locale is {}.", locale);

		return "main";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(@ModelAttribute UserVo bean, HttpServletRequest req) throws Exception {

		req.setCharacterEncoding("UTF-8");

//		if (!(req.getParameter("kakao_id").equals(bean.getKakao_id()))) {
			// kakao_id PK�� ������ ���� ������ ���� �Է��� �ȵ�..
			bean.setKakao_id(req.getParameter("kakao_id"));
			bean.setKakao_nick(req.getParameter("kakao_nick"));
			bean.setKakao_profile_image(req.getParameter("kakao_profile_image"));
			bean.setKakao_thumbnail_image(req.getParameter("kakao_thumbnail_image"));
			userService.userInsertOne(bean);
			System.out.println(bean);
			System.out.println("�Է�");
//			} else {
//				System.out.println("���̵� �����ϲ� �������� ����");
//				return "main";
//			}
		return "main";
	}

	@RequestMapping(value = "/deleteaccount", method = RequestMethod.GET)
	public String unlinkPage() {
		System.out.println("�� ���� ���� ������ �̵� (ȸ�� Ż��)");
		return "loginoutdel/deleteaccount";
	}
	
	@RequestMapping(value = "/deleteaccount", method = RequestMethod.POST)
	public String unlink(@ModelAttribute UserVo bean, HttpServletRequest req) {
		// db���� ���̵� �����ؾ��ϴϱ� post�������
		String no = req.getParameter("kakao_id");
		System.out.println(no);
		userService.userDeleteOne(no);
		return "redirect:/main";
	}

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Locale locale, Model model) {

		logger.info("�Խ���", locale);

		bbsService.bbsListAll(model);

		return "user/board";
	}

	@RequestMapping(value = "/board/{bbspage}", method = RequestMethod.GET)
	public String board(Locale locale, Model model, @PathVariable("bbspage") int bbspage) {

		logger.info("�Խ���", locale);
		System.out.println("�Խ��� �������� " + bbspage);
		bbsService.bbsListAll(model);

		return "user/board";
	}

	@RequestMapping(value = "/board/detail/{postno}", method = RequestMethod.GET)
	public String detail(Locale locale, Model model, Model cmtmodel, @PathVariable("postno") int no) {

		logger.info("�Խñ� �� ������", locale);
		bbsService.bbsDetailOne(no, model);
		
		commentService.commentList(no, cmtmodel);

		return "user/detail";
	}

	@RequestMapping(value = "/edit/{postno}", method = RequestMethod.GET)
	public String editpage(Locale locale, Model model, @PathVariable("postno") int no) {

		logger.info("�Խñ� ���� ������", locale);
		bbsService.bbsDetailOne(no, model);

		return "user/edit";
	}

	@RequestMapping(value = "/edit/{postno}", method = RequestMethod.PUT)
	public String edit(@PathVariable("postno") int no, BbsVo bean, Locale locale) throws Exception {
		bbsService.bbsUpdateOne(bean);
		System.out.println("���� ����");
		return "redirect:/board";
	}

	@RequestMapping(value = "/delete/{postno}", method = RequestMethod.GET)
	public String delete(@PathVariable("postno") int no, Model model) throws Exception {
		bbsService.bbsDetailOne(no, model);
		//System.out.println(bean+"����");
		return "user/delete";
	}
	@RequestMapping(value = "/delete/{postno}", method = RequestMethod.DELETE)
	public String deletecompl(@PathVariable("postno") int no, BbsVo bean, Locale locale) throws Exception {
		bbsService.bbsDeleteOne(no);
		System.out.println(bean+"����");
		return "redirect:/board";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writeadd(Locale locale, @ModelAttribute BbsVo bean, HttpServletRequest req) {
		
		logger.info("�Խñ� �ۼ�", locale);
		System.out.println("add ����Ʈ ����");
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
		logger.info("��������", locale);

		return "user/notice";
	}

	@RequestMapping(value = "/question", method = RequestMethod.GET)
	public String complaint(Locale locale, Model model) throws Exception {
		logger.info("���ǻ���", locale);

		return "user/question";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Locale locale, Model model) {
		logger.info("�Խñ� �ۼ�������", locale);
		System.out.println("add �� ����");
		//īī���г��ӹ޾ƿͼ� �۾���� �̸��� �г��� ������.
		return "user/write";
	}

}