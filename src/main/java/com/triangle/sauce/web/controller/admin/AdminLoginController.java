package com.triangle.sauce.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/_admin")
public class AdminLoginController {
	@GetMapping("/login")
	public String index() {
		return "admin/login";
	}

	@PostMapping("/login")
	public String login() {
		return "redirect:/_admin/dashboard";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "admin/dashboard";
	}
}
