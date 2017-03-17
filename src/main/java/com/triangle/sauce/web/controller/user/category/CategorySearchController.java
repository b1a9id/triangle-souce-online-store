package com.triangle.sauce.web.controller.user.category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/categories")
@Controller
public class CategorySearchController {
	@GetMapping
	public String search() {
		return "user/category/search";
	}
}
