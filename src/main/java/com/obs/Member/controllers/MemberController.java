package com.obs.Member.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.obs.Member.domain.Member;
import com.obs.Member.services.impl.MemberServiceImpl;

@Controller
@RequestMapping("/members")
public class MemberController {
private MemberServiceImpl memberServiceImpl;
	
	@Autowired
	public MemberController(MemberServiceImpl memberServiceImpl) {
		super();
		this.memberServiceImpl = memberServiceImpl;
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@RequestMapping("/list")
	public String list(Model model){
		model.addAttribute("members", memberServiceImpl.list());
		return "members/list";
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@RequestMapping("/view")
	public String view(Model model){
		return "members/view";
	}
	
	@RequestMapping("/createMember")
	public String createAuthor(Model model) {
		model.addAttribute("member", new Member());
		return "auth/createaccount";
	}
	
	@RequestMapping(value = "/processForm", method = RequestMethod.POST)
	public String processForm(@Valid @ModelAttribute("member") Member member, BindingResult theBindingResult) {
		if(theBindingResult.hasErrors()) {
			return "/auth/createaccount";
		}
		/*
		 * Checks if a password == confirm_password before a member gets created.
		 */
		if (!member.getPassword().equals(member.getConfirmPassword())) {
			return "redirect:/members/createMember";
		}
		memberServiceImpl.save(member);
		return "redirect:/";
	}
	
	/*
	 * Pre-processes 
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		//Removes leading and trailing whitespace.
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
