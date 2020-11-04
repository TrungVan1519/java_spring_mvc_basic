package com.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityAppConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
	        .usersByUsernameQuery("SELECT `username`, `password`, `enabled` FROM `bcrypt_account` WHERE `username` = ?")
	        .authoritiesByUsernameQuery(
	        		"SELECT bcrypt_account.username, bcrypt_authority.authority "
	        		+ "FROM bcrypt_account, bcrypt_authority "
	        		+ "WHERE bcrypt_account.username = ? "
	        		+ "AND bcrypt_account.id = bcrypt_authority.account_id");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.csrf().disable()
			.authorizeRequests()
//					.anyRequest().authenticated()
					.antMatchers("/home", "/contact-us").hasAnyRole("COMMUNISM", "IMPERIALISM", "CAPITALISM")
					.antMatchers("/products/").hasRole("CAPITALISM")
					.antMatchers("/order/**").hasAnyRole("COMMUNISM", "IMPERIALISM")
					.and()
			.formLogin()
					.loginPage("/login/loginController").loginProcessingUrl("/loginView")
					.usernameParameter("username").passwordParameter("password")
					// Cach 1: Dung defaultSuccessUrl()
					.defaultSuccessUrl("/products", true)
					// Cach 2: Tuong tu nhu defaultSuccessUrl()
//					.successHandler(new AuthenticationSuccessHandler() {
//						
//						@Override
//						public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//								Authentication authentication) throws IOException, ServletException {
//							// TODO Auto-generated method stub
//							 RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//							 redirectStrategy.sendRedirect(request, response, "/students");
//						}
//					})
					.failureUrl("/login/loginController?error=The account not exists in DB")
					.permitAll()
					.and()
			.exceptionHandling().accessDeniedPage("/login/loginController?error=Don't have enough authorities")
					.and()
			.logout()
					.permitAll();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/source/**")
		   .and()
		   .ignoring().antMatchers("/source-image/**");
	}
}

