package com.olx.login.service;

import com.olx.login.dto.User;

public interface LoginService {
	
	public String authenticate(User user);
	public Boolean logout(String authToken);
	public User register(User user);
	public User getUser(String userToken);
	public Boolean tokenValidatation(String userToken);
}
