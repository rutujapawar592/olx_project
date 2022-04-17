package com.olx.login.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.olx.login.entity.UserEntity;
import com.olx.login.repository.UserRepo;

//import com.olx.login.repository.LoginRepo;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepo loginRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		//Write a login using repository api to read information about the given username
		List<UserEntity> userEntityList = loginRepo.findByUserName(userName);
		if (userEntityList==null || userEntityList.size()==0) {
			throw new UsernameNotFoundException(userName);
		}
		
		UserEntity userEntity = userEntityList.get(0);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		UserDetails userDetails = new User(userName, passwordEncoder.encode(userEntity.getPassword()), authorities);
		return userDetails;
	}
	
	
		
}
