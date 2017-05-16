package com.springtutorial.service;

import lombok.Data;
import org.springframework.security.core.authority.AuthorityUtils;

import com.springtutorial.domain.User;

@Data
public class LoginUserDetails extends
		org.springframework.security.core.userdetails.User {
	private final User user;
	
	public LoginUserDetails(User user) {
		super(user.getUsername(), user.getEncodedPssword(),
				AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}
}