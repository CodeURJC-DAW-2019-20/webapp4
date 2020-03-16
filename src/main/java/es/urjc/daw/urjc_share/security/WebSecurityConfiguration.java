package es.urjc.daw.urjc_share.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@Order(2)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	String[] resources = new String[]{
            "/include/*","/css/","/icons/","/img/","/js/","/layer/*","/png/", "*.jpg", "*.pdf"
    };
	
	
	@Autowired
    public UserRepositoryAuthenticationProvider authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Public pages
		http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/ranking").permitAll();
        http.authorizeRequests().antMatchers("/profile").permitAll();
        http.authorizeRequests().antMatchers("/searched/subject").permitAll();
        http.authorizeRequests().antMatchers("/searched").permitAll();
        http.authorizeRequests().antMatchers("/index").permitAll();
        http.authorizeRequests().antMatchers("/notes").permitAll();
        http.authorizeRequests().antMatchers("/listsubjects").permitAll();
        http.authorizeRequests().antMatchers("/register").permitAll();
        http.authorizeRequests().antMatchers(resources).permitAll();
        http.authorizeRequests().antMatchers("/user/new").permitAll();    

        // Private pages (all other pages)
        http.authorizeRequests().antMatchers("/user").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/user/{id}").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/created").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/modalAdmin").hasAnyRole("ADMIN");
        

        // Login form
        http.formLogin().loginPage("/loginUser");
        http.formLogin().usernameParameter("nickname");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/loginerror");
        

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
        
        // Disable CSRF at the moment
        http.csrf().disable();
        
        
        http.exceptionHandling().accessDeniedPage("/error.hmtl");
        
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
    	// Database authentication provider
        auth.authenticationProvider(authenticationProvider);
	}
	
}
