package com.nicolas.gts.mychurch.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/churches")
public class ChurchResourse {
	
	@RequestMapping(method=RequestMethod.GET)
	public String listChurches() {
		return "Rest is working";
	}

}
