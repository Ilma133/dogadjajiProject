package com.example.webprogr;

import com.example.webprogr.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class ApplicationSecurityConfig {
	private final MyUserDetailsService myUserDetailsService;

	public ApplicationSecurityConfig(MyUserDetailsService myUserDetailsService) {
		this.myUserDetailsService = myUserDetailsService;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider providerauth() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(myUserDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}


	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable();
		http
				.authorizeHttpRequests((authz) -> authz.antMatchers("/user/register").permitAll()
						.antMatchers("/security/user/Edit/**").hasAuthority("ADMIN")
						//.antMatchers("/lokacija/addNew").hasAuthority("ADMIN")
						.anyRequest().authenticated()
				).formLogin()
				.and().exceptionHandling().accessDeniedPage("/AccessPage");
		http.authenticationProvider(providerauth());
		return http.build();

/*
		http.cors();
		http.csrf().disable();

		http
				.authorizeHttpRequests((authz) ->
						authz.antMatchers("/user/register").permitAll()
								.antMatchers("/resources/**", "/assets/**").permitAll()
								//.antMatchers("/").permitAll()
								.antMatchers("/security/users/Edit/**").hasAuthority("ADMIN")
								.anyRequest().authenticated()
				).formLogin()
				.defaultSuccessUrl("/index")
				.and()
				.exceptionHandling().accessDeniedPage("/Access");
		//.failureUrl("/login?error")
		//.permitAll()
		//.and()
		//.logout()
		//.logoutUrl("/logout")
		//.invalidateHttpSession(true)
		//.logoutSuccessUrl("/login?logout")
		//permitAll();
		http.authenticationProvider(providerauth());
		return http.build();*/

		/*http.authorizeRequests().antMatchers("/login").permitAll()
				//.csrf().disable()
				//.authorizeRequests()
				.antMatchers(
						"/login", "/resources/**", "/css/**", "/fonts/**", "/img/**").permitAll()
				.antMatchers("/security/user/Edit/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				//.loginPage("/login").permitAll()
				.and()
				.logout().invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/index").permitAll();

		return http.build();*/


	}
}







