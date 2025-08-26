package httpbasic_demo.com.abhi.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import httpbasic_demo.com.abhi.entity.User;

/**
 * @author Abhishek Kumar
 */
public class AuthenticatedUser implements UserDetails {

	private static final long serialVersionUID = 1L;
	private User user;

	public AuthenticatedUser(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
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
