package com.volapp;



import static com.volapp.auth.AuthConstants.SIGN_UP_URL;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import com.volapp.charityuser.MySQLUserDetailsService;

@CrossOrigin
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MySQLUserDetailsService mySQLDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.cors()
	      .and()
	      .csrf().disable()
	      .authorizeRequests().antMatchers(SIGN_UP_URL).permitAll()
	      .anyRequest().authenticated()
	      .and()
	      .addFilter(new com.volapp.auth.JWTAuthenticationFilter(authenticationManager()))
	      .addFilter(new com.volapp.auth.JWTAuthenticationFilter(authenticationManager()))
	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
}
	  
  @Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(mySQLDetailsService).passwordEncoder(passwordEncoder());
	}	
	
	@Bean
	  CorsConfigurationSource corsConfigurationSource() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration corsConfig = new CorsConfiguration();
	    corsConfig.applyPermitDefaultValues();
	    corsConfig.setExposedHeaders(Arrays.asList("Authorization"));
	    source.registerCorsConfiguration("/**", corsConfig);
	    return source;
	  }
}