package httpbasic_demo.com.abhi.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import httpbasic_demo.com.abhi.entity.User;

/**
 * @author Abhishek Kumar
 */
public class AuthenticatedUser implements UserDetails {

	private static final long serialVersionUID = 1L;
	private User user;
	private List<GrantedAuthority> authorities;

	public AuthenticatedUser(User user,List<GrantedAuthority> auth) {
		this.user = user;
		this.authorities = auth;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

}
