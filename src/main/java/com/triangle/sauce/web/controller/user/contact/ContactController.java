package com.triangle.sauce.web.controller.user.contact;

import com.triangle.sauce.core.model.ContactType;
import netscape.security.ForbiddenTargetException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contact")
@SessionAttributes("form")
public class ContactController {

	private static final String FORM_MODEL_KEY = "form";
	private static final String ERRORS_MODEL_KEYS = BindingResult.MODEL_KEY_PREFIX + FORM_MODEL_KEY;

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
	public String input(
			@Validated @ModelAttribute(FORM_MODEL_KEY) ContactForm form,
			BindingResult errors,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute(FORM_MODEL_KEY, form);
		redirectAttributes.addFlashAttribute(ERRORS_MODEL_KEYS, errors);
		if (errors.hasErrors()) {
			return "redirect:/contact";
		}

		redirectAttributes.getFlashAttributes().clear();
		return "redirect:/contact?step=review";
	}

	@GetMapping(params = "step=review")
	public String review(
			@ModelAttribute(FORM_MODEL_KEY) ContactForm form,
			BindingResult errors) {
		if (errors.hasErrors()) {
			return "redirect:/contact";
		}
		return "user/contact/step2";
	}

	@PostMapping(params = "step=confirm")
	public String confirm(
			@Validated @ModelAttribute(FORM_MODEL_KEY) ContactForm form,
			BindingResult errors,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute(FORM_MODEL_KEY, form);
		redirectAttributes.addFlashAttribute(ERRORS_MODEL_KEYS, errors);
		if (errors.hasErrors()) {
			return "redirect:/contact";
		}

		redirectAttributes.getFlashAttributes().clear();
		return "redirect:/contact?step=finish";
	}

	@GetMapping(params = "step=finish")
	public String finish(
			@Validated @ModelAttribute(FORM_MODEL_KEY) ContactForm form,
			BindingResult errors,
			SessionStatus status) {
		if (errors.hasErrors()) {
			return "redirect:/contact";
		}
		status.setComplete();
		return "user/contact/step3";
	}
}
