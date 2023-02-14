package com.example.webprogr.models;

import com.example.webprogr.security.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	public User(String username,String password){
		this.username=username;
		this.password=password;
	}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String username;
    private String password;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
			@JoinTable(
					name="user_role",
					joinColumns = {@JoinColumn(name="user_id")},
					inverseJoinColumns = {@JoinColumn(name = "role_id")}

			)
    Set<Role> roles=new HashSet<>();

}
