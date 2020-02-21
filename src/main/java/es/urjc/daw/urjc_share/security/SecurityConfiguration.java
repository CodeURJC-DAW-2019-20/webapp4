package es.urjc.daw.urjc_share.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	String[] resources = new String[]{
            "/include/*","/css/","/icons/","/img/","/js/","/layer/*"
    };
	
	
	/*@Autowired
    public UserRepositoryAuthenticationProvider authenticationProvider;*/

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
        http.authorizeRequests().antMatchers("/usuario/nuevo").permitAll();       

        // Private pages (all other pages)
        http.authorizeRequests().antMatchers("/usuarios").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/usuario/{id}").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/created").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/addGrade").hasAnyRole("ADMIN");
        

        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("email");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/index");
        http.formLogin().failureUrl("/loginerror");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
        
        // Disable CSRF at the moment
        http.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // Enable default password encoder (mandatory since Spring Security 5 to avoid storing passwords in plain text)
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        // User
        auth.inMemoryAuthentication().withUser("user").password(encoder.encode("pass")).roles("USER");
	}
}
