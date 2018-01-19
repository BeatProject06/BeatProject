package com.hb.major.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QnaController {
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/question", method = RequestMethod.GET)
	public String complaint(Locale locale, Model model) throws Exception {
		logger.info("���ǻ���", locale);

		return "user/question";
	}

	
}
