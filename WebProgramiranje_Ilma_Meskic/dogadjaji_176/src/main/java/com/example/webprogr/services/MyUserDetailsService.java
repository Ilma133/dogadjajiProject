package com.example.webprogr.services;

import com.example.webprogr.security.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.webprogr.models.User;
import com.example.webprogr.models.UserPrincipal;
import com.example.webprogr.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
    UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User user =userRepository.findByUsername(name);
		
		if (user ==null) {
			throw new UsernameNotFoundException("Korisnik nije pronadjen!");
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		String role=((Role)user.getRoles().toArray()[0]).getDescription();
		authorities.add(new SimpleGrantedAuthority(role));
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
	}

}
