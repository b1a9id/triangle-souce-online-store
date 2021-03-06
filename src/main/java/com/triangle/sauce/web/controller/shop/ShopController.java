package com.triangle.sauce.web.controller.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {
	@GetMapping("/about")
	public String about() {
		return "shop/about";
	}

	@GetMapping("/guide")
	public String guide() {
		return "shop/guide";
	}

	@GetMapping("/rule")
	public String rule() {
		return "shop/rule";
	}

	@GetMapping("/privacy")
	public String privacy() {
		return "shop/privacy";
	}

	@GetMapping("/sctact")
	public String sctact() {
		return "shop/sctact";
	}
}
