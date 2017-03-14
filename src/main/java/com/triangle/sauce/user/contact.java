package com.triangle.sauce.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class contact {
	@GetMapping
	public String index() {
		return "user/contact/contact";
	}
}
