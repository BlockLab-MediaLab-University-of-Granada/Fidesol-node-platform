package com.fidesol.bcp.domain.model.mysql;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "User")
@EnableAutoConfiguration
@Table(name = "users")
public class User {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "token")
	private String token;
	@Column(name = "rol")
	private int rol;

	public User() {

	}

	public User(int user, String username, String password, String token, int rol) {
		this.id = user;
		this.username = username;
		this.password = password;
		this.token = token;
		this.rol = rol;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int user) {
		this.id = user;
	}

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
