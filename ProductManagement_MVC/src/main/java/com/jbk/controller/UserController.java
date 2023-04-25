package com.jbk.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.entity.User;
import com.jbk.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping(value = "/login")
	public ModelAndView login(@ModelAttribute User user, Model model, HttpSession session) {
		User dbUser = service.login(user);
		if (dbUser != null) {
			session.setAttribute("username", dbUser.getFirstName());
			session.setAttribute("role", dbUser.getRole());
			return new ModelAndView("home");
		} else {
			model.addAttribute("msg", "Invalid Credientials !!");
			return new ModelAndView("login");
		}

	}

	@PostMapping(value = "/adduser")
	public ModelAndView addUser(@ModelAttribute User user, Model model) {
		boolean isAdded = service.addUser(user);
		if (isAdded) {
			model.addAttribute("msg", "User Added !");
			return new ModelAndView("registration");

		} else {
			model.addAttribute("msg", "User Already Exists");
			return new ModelAndView("registration");

		}
	}

	@GetMapping(value = "/alluser")
	public ModelAndView allUser(Model model, HttpSession session) {
		if (session.getAttribute("username")!=null) {
			List<User> list = service.allUser();

			return new ModelAndView("alluser", "usrList", list);
		} else {
			return new ModelAndView("login", "msg", "Login First");

		}

	}

	@GetMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		if (session != null) {
			session.invalidate();

		}
		return new ModelAndView("login");
	}

}
