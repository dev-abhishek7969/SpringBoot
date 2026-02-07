package httpbasic_demo.com.abhi.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import httpbasic_demo.com.abhi.model.AuthenticatedUser;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@GetMapping
	public String adminOps() {
		AuthenticatedUser user = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return "Admin Access! Hi " + user.getUsername() + ", you are allowed!";
	}

}
