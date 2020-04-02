package es.urjc.daw.urjc_share.security;

import java.util.ArrayList;
import java.util.List;

import es.urjc.daw.urjc_share.component.UserComponent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserComponent userComponent;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		String nickname = auth.getName();
		String password = (String) auth.getCredentials();
		
		User user = userRepository.findByNickname(nickname);
		
		if (user == null) {
			throw new BadCredentialsException("User not found");
		}
		
		
		if (!new BCryptPasswordEncoder().matches(password, user.getPasswordHash())) {
			
			throw new BadCredentialsException("Wrong password");
		}else {

			userComponent.setEntityUser(user);

			List<GrantedAuthority> roles = new ArrayList<>();
			for (String role : user.getRoles()) {
				roles.add(new SimpleGrantedAuthority(role));
			}
			
			return new UsernamePasswordAuthenticationToken(user.getNickname(), password, roles);
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}



}
