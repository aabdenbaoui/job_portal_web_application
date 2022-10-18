package com.aabdenbaoui.management.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	

	@Autowired
    UserDetailsService userDetailsService;
//    @Autowired
//	AuthenticationService authenticationService;
//
// 
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(this.authenticationService);
//    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{

		  http.authorizeRequests()
		                  .antMatchers("/login", "/register", "/css/**", "/js/**", "/h2-console/**", "/console/**", "/users/save")
		                  .permitAll()
		                  .anyRequest().authenticated()        
		                  .and().csrf().ignoringAntMatchers("/h2-console/**")
		                  .and().headers().frameOptions().sameOrigin()
		                  .and().formLogin().loginPage("/login")
		                  .usernameParameter("email")
		                  .defaultSuccessUrl("/home", true)
		                  .permitAll()
		                  .and()
		                  .logout().permitAll()
		                  .and()
		                  .httpBasic();	 
	}
	


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
