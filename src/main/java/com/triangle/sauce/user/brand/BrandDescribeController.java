package com.triangle.sauce.user.brand;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands/describe")
public class BrandDescribeController {
	@GetMapping("/{id}")
	public String describe(@PathVariable Long id) {
		return "user/brand/describe";
	}
}
