package com.springtutorial.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springtutorial.domain.Member;
import com.springtutorial.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("api/member")
public class MemberRestController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(method = RequestMethod.GET)
	List<Member> getCustomers() {
		List<Member> members = memberService.findAll();
		return members;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	Member getCustomer(@PathVariable Integer id) {
		Member member = memberService.findOne(id);
		return member;
	}
	
	// new member create
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	Member postMembers(@RequestBody Member member) {
		return memberService.create(member);
	}

	// member update
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	Member putMember(@PathVariable Integer id, @RequestBody Member member) {
		member.setId(id);
		return memberService.update(member);
	}
	
	// member delete 
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteCustomer(@PathVariable Integer id) {
		memberService.delete(id);
	}
}