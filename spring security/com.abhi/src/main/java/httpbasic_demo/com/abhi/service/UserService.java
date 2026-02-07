package httpbasic_demo.com.abhi.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import httpbasic_demo.com.abhi.dto.AuthorityDTO;
import httpbasic_demo.com.abhi.dto.RoleDTO;
import httpbasic_demo.com.abhi.dto.UserDTO;
import httpbasic_demo.com.abhi.entity.Authority;
import httpbasic_demo.com.abhi.entity.Role;
import httpbasic_demo.com.abhi.entity.User;
import httpbasic_demo.com.abhi.model.AuthenticatedUser;
import httpbasic_demo.com.abhi.repository.AuthorityRepository;
import httpbasic_demo.com.abhi.repository.RolesRepository;
import httpbasic_demo.com.abhi.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User register(UserDTO userDTO) {

		User u = new User();
		u.setEmail(userDTO.email());
		u.setUsername(userDTO.username());
		u.setPassword(passwordEncoder.encode(userDTO.password()));
		
		/*New code */
		 Set<Role> roles = userDTO.roles().stream().map(roleDTO -> {
	            //Single role
	            Role role = getOrCreateRole(roleDTO);

	            //multiple authorities
	            Set<Authority> authorities = getAuthoritiesFromRequest(roleDTO);

	            role.setAuthorities(authorities);

	            return role;
	        }).collect(Collectors.toSet());

	        u.setRoles(roles);
		
		return userRepository.save(u);

	}
	
	private Set<Authority> getAuthoritiesFromRequest(RoleDTO roleDTO) {
		return roleDTO.authorities().stream().map(authorityDTO -> {
			return getOrCreateAuthority(authorityDTO);
		}).collect(Collectors.toSet());
	}

	private Authority getOrCreateAuthority(AuthorityDTO authorityDTO) {
		return authorityRepository.findByName(authorityDTO.name()).orElseGet(() -> {
			Authority auth = new Authority();
			auth.setName(authorityDTO.name());
			return authorityRepository.save(auth);
		});
	}

	private Role getOrCreateRole(RoleDTO roleDTO) {
		return rolesRepository.findByName(roleDTO.name()).orElseGet(() -> {
			Role r = new Role();
			r.setName(roleDTO.name());
			return rolesRepository.save(r);
		});
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = userRepository.findByUsername(username);

		// fetch the authority and roles
		List<GrantedAuthority> authorityList = u.getRoles().stream()
				.flatMap(role -> role.getAuthorities().stream().map(auth -> new SimpleGrantedAuthority(auth.getName())))
				.collect(Collectors.toList());
		
		System.out.println("authorities::::::::::::::"+authorityList);
		
		authorityList.addAll(u.getRoles().stream().map(r -> new SimpleGrantedAuthority("ROLE_"+r.getName())).collect(Collectors.toList()));

		System.out.println("authorities::::::::::::::"+authorityList);

		return new AuthenticatedUser(u,authorityList);
	}

}
