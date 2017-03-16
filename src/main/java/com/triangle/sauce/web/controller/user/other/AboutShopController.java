package com.triangle.sauce.web.controller.user.other;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/other/about-shop")
public class AboutShopController {
	@GetMapping
	public String aboutShop() {
		return "user/other/about-shop";
	}
}
