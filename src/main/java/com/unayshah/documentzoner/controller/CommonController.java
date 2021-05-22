package com.unayshah.documentzoner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
}
