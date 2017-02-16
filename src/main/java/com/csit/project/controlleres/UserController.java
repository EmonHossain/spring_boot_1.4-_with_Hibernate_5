package com.csit.project.controlleres;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {
	

	@RequestMapping("/home")
	@ResponseBody
	public String showHome(Principal principal) {		
		return "success "+principal.getName();
	}
	@RequestMapping("/home/hello")
	@ResponseBody
	public String showHsdf(Principal principal) {		
		return "hello "+principal.getName();
	}
	
	@RequestMapping("/")
	public String login(){
		return "login";
	}
	

}
