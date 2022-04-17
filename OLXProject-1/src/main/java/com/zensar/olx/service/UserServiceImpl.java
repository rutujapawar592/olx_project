package com.zensar.olx.service;

import org.springframework.stereotype.Service;

import com.zensar.olx.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public void login(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateToken() {
		// TODO Auto-generated method stub
		return false;
	}

}