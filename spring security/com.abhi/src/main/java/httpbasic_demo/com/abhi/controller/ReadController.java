package httpbasic_demo.com.abhi.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import httpbasic_demo.com.abhi.model.AuthenticatedUser;

@RestController
@RequestMapping("/api/greet")
public class ReadController {

	@GetMapping
	public String greet() {
		//get the user from security context holder
		AuthenticatedUser user = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return "Hi "+user.getUsername()+" you are allowed!";
	}
}
