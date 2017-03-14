package com.triangle.sauce.web.controller.user.contact;

import com.triangle.sauce.core.model.ContactType;
import netscape.security.ForbiddenTargetException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/contact")
@SessionAttributes("form")
public class ContactController {

	public static final String FORM_MODEL_KEY = "form";

	@ExceptionHandler(ForbiddenTargetException.class)
	public String exceptionHandler(ForbiddenTargetException exception) {
		return "redirect:/contact";
	}

	@ModelAttribute(FORM_MODEL_KEY)
	public ContactForm setupContactForm() {
		return new ContactForm();
	}

	@ModelAttribute("types")
	public ContactType[] setupContactType() {
		return ContactType.values();
	}

	@GetMapping
	public String index(Model model) {
		ContactForm form = (ContactForm) model.asMap().get(FORM_MODEL_KEY);
		if (form == null) {
			form = new ContactForm();
		}
		model.addAttribute(FORM_MODEL_KEY, form);
		return "user/contact/step1";
	}

	@PostMapping(params = "step=input")
	public String input(@ModelAttribute(FORM_MODEL_KEY) ContactForm form) {
		System.out.println(form.getEmail());
		return "redirect:/contact?step=review";
	}

	@GetMapping(params = "step=review")
	public String review(
			@ModelAttribute(FORM_MODEL_KEY) ContactForm form) {
		return "user/contact/step2";
	}

	@PostMapping(params = "step=confirm")
	public String confirm(@ModelAttribute(FORM_MODEL_KEY) ContactForm form) {
		return "redirect:/contact?step=finish";
	}

	@GetMapping(params = "step=finish")
	public String finish(
			SessionStatus status) {
		status.setComplete();
		return "user/contact/step3";
	}
}
