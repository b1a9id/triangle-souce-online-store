package com.triangle.sauce.web.controller.user.item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items/describe")
public class ItemDescribeController {
	@GetMapping("/{id}")
	public String describe(@PathVariable Long id) {
		return "user/item/describe";
	}
}
