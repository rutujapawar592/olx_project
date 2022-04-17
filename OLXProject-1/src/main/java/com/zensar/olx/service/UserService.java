package com.zensar.olx.service;

import com.zensar.olx.model.User;

public interface UserService {

	public void login(User user);

	public boolean logout();

	public User register(User user);

	public User getUser(String username);

	public boolean validateToken();

}