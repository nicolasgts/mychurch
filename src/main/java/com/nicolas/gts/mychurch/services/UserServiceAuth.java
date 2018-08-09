	package com.nicolas.gts.mychurch.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.nicolas.gts.mychurch.security.UserSS;

public class UserServiceAuth {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
