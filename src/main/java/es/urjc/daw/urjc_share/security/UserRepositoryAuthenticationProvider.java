package es.urjc.daw.urjc_share.security;

import java.util.ArrayList;
import java.util.List;

import es.urjc.daw.urjc_share.component.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import es.urjc.daw.urjc_share.data.UserRepository;
import es.urjc.daw.urjc_share.model.User;


@Component
public class UserRepositoryAuthenticationProvider implements AuthenticationProvider{
	@Autowired
	private UserRepository userRepository;
    @Autowired
    private UserComponent currentUser;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String nickname = auth.getName();
		User user = userRepository.findByNickname(auth.getName());
		if (user == null) {
			throw new BadCredentialsException("User not found");
		}
		String password = (String) auth.getCredentials();
		if (!new BCryptPasswordEncoder().matches(password, user.getPasswordHash())) {
			throw new BadCredentialsException("Wrong password");
		}
		List<GrantedAuthority> roles = new ArrayList<>();
		for (String role : user.getRoles()) {
			roles.add(new SimpleGrantedAuthority(role));
		}
		currentUser.setEntityUser(user);
		return new UsernamePasswordAuthenticationToken(user.getNickname(), password, roles);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}



}
