package com.springtutorial.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springtutorial.domain.Member;
import com.springtutorial.service.MemberService;

import java.util.List;

@Controller
@RequestMapping("members")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@ModelAttribute
	MemberForm setUpForm() {
		return new MemberForm();
	}

	@RequestMapping(method = RequestMethod.GET)
	String list(Model model) {
		List<Member> members = memberService.findAll();
		model.addAttribute("members", members);
		return "members/list";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	String create(@Validated MemberForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return list(model);
		}
		Member member = new Member();
		// TODO 이 부분은 공부가 필요하다. 유연하게 하려면 Dozer나 ModelMapper가 사용된다고 한다.
		BeanUtils.copyProperties(form, member);
		memberService.create(member);
		return "redirect:/members";
	}
	
	@RequestMapping(value="edit", params = "form", method = RequestMethod.GET)
	String editForm(@RequestParam Integer id, MemberForm form) {
		Member member = memberService.findOne(id);
		BeanUtils.copyProperties(member, form);
		return "members/edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	String edit(@RequestParam Integer id, @Validated MemberForm form,
			BindingResult result) {
		if (result.hasErrors()) {
			return editForm(id, form);
		}
		Member member = new Member();
		BeanUtils.copyProperties(form, member);
		member.setId(id);
		memberService.update(member);
		return "redirect:/members";
	}
	
	@RequestMapping(value = "edit", params="goToTop")
	String goToTop() {
		return "redirect:/members";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	String edit(@RequestParam Integer id) {
		memberService.delete(id);
		return "redirect:/members";
	}
}