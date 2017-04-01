package com.triangle.sauce.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class LoginController {
	@GetMapping("/login")
	public String index() {
		return "user/login";
	}

	@PostMapping("/login")
	public String login() {
		return "redirect:/mypage/dashboard";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "user/dashboard";
	}
}
