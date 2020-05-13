package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	
public class MainController {

	@RequestMapping("/main")
	public String main () throws Exception {
		String url = "main";
		return url;
	}
}
