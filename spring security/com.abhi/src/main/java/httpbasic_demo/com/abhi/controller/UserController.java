package httpbasic_demo.com.abhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import httpbasic_demo.com.abhi.dto.UserDTO;
import httpbasic_demo.com.abhi.service.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/hello")
	public String helloController() {
		return "Hello controller";
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody UserDTO userDTO){
		userService.register(userDTO);
		return ResponseEntity.ok("User created successfully");
	}

}
