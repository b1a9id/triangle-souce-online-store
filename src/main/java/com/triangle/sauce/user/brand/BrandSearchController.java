package com.triangle.sauce.user.brand;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/brands")
@Controller
public class BrandSearchController {
	@GetMapping
	public String search() {
		return "user/brand/search";
	}
}
