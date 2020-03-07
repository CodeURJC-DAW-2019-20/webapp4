package es.urjc.daw.urjc_share.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class RestSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
    @Autowired
    public UserRepositoryAuthenticationProvider authenticationProvider;

    
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		configureUrlAuthorization(http);
		
		http.csrf().disable();
		
		http.httpBasic();
		
		http.logout().logoutSuccessHandler((rq, rs, a) ->{
			
		});
		
	}
    
	private void configureUrlAuthorization(HttpSecurity http) throws Exception{
		
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/user/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/user/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/subjects/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/degrees/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/created/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/created/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/modalAdmin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/modalAdmin/**").hasRole("ADMIN");
		
		
		
	}

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // Database authentication provider
        auth.authenticationProvider(authenticationProvider);
    }
}
