package com.jbk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	// welcome page
	@RequestMapping(value = "/")
	public ModelAndView loginPage() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/adduserpage")
	public ModelAndView addUserPage(HttpSession session) {

		if (session.getAttribute("username") != null && session.getAttribute("role").equals("Admin")) {
			return new ModelAndView("registration");
		} else {
			return new ModelAndView("login", "msg", "Login As Admin");

		}

	}

}
