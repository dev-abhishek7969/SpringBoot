package httpbasic_demo.com.abhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import httpbasic_demo.com.abhi.dto.UserDTO;
import httpbasic_demo.com.abhi.entity.User;
import httpbasic_demo.com.abhi.model.AuthenticatedUser;
import httpbasic_demo.com.abhi.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User register(UserDTO userDTO) {

		User u = new User();
		u.setEmail(userDTO.getEmail());
		u.setUsername(userDTO.getUsername());
		u.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		return userRepository.save(u);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = userRepository.findByUsername(username);
		return new AuthenticatedUser(u);
	}

}
