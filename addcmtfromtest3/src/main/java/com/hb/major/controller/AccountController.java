package com.hb.major.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hb.major.model.entity.UserVo;
import com.hb.major.service.user.UserService;

@Controller
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	private UserService userService;
	
	
	
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

	
	
	
}
