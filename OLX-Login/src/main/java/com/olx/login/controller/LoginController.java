package com.olx.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.login.dto.User;
import com.olx.login.service.LoginService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/olx/login")
@CrossOrigin(origins = "*")

public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping(value = "/user/authenticate", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	//@ApiOperation(value = "Authenticating a User", notes = "This Rest API helps to Authenticated User Data")
	public String authenticate(@RequestBody User user) {
	        return loginService.authenticate(user);
	}
	
	
	@DeleteMapping(value = "/user/logout")
	//@ApiOperation(value = "Logout a User", notes = "This Rest API helps to Logout a Authenticated User")
	public Boolean logout(@RequestHeader("auth-token") String authToken) {
	        return loginService.logout(authToken);
	}
	
	
	@PostMapping(value = "/user", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	//@ApiOperation(value = "Register a User", notes = "This Rest API helps to Register a User")
	public User register(@RequestBody User user) {
	        return loginService.register(user);
	}
	
	
	@GetMapping(value = "/user", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Getting a User Information", notes = "This Rest API helps to get Authenticated User Data")
	public User getUser(@RequestBody String authToken) {
	        return loginService.getUser(authToken);
	}
	
	
	@GetMapping(value = "/token/validate")
	@ApiOperation(value = "Authenticating a User", notes = "This Rest API helps to Authenticated User Data")
    public Boolean tokenValidatation(@RequestBody String authToken) {
	        return loginService.tokenValidatation(authToken);
	}
}
