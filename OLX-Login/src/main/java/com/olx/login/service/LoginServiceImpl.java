package com.olx.login.service;

import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.olx.login.dto.User;
import com.olx.login.entity.UserEntity;
import com.olx.login.repository.UserRepo;
import com.olx.login.security.JwtUtil;


@Service
public class LoginServiceImpl implements LoginService{
	
	Map<String, User> users = new HashMap<>();
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	UserRepo loginRepo;
	@Autowired
	JwtUtil jwtUtil;
	
	@Override
	public String authenticate(User user) {
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
		}
		catch (AuthenticationException e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}
		String jwt=jwtUtil.generateToken(user.getUserName());
		return jwt;
		
		
	}

	@Override
	public Boolean logout(String authToken) {
		// TODO Auto-generated method stub
		Iterator<Entry<String, User>> itrUser = users.entrySet().iterator();
		while(itrUser.hasNext()) {
			Entry<String, User> entryset = itrUser.next();
			if(authToken == entryset.getKey())
			{
			
				return true;
			}
		}
		return false;
	}

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		UserEntity userEntity = convertDTOIEntity(user);
		userEntity = loginRepo.save(userEntity);

		return convertEntityIDTO(userEntity);
	}

	@Override
	public User getUser(String userToken) {
		// TODO Auto-generated method stub
		
		return new User(1,"Anand", "Kulkarni", "anand", "anand123", "anand123@gmail.com", "12345");
	}

	@Override
	public Boolean tokenValidatation(String userToken) {
		// TODO Auto-generated method stub
		Boolean checkToken = logout(userToken);
		if(checkToken == true)
			return true;
		return false;
	}
	
	private User convertEntityIDTO(UserEntity userEntity) {

		User user = modelMapper.map(userEntity, User.class);
		return user;
	}
	private UserEntity convertDTOIEntity(User user) {
		
		UserEntity userEntity = modelMapper.map(user, UserEntity.class);
		
		return userEntity;
	}

}
