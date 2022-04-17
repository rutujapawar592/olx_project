package com.olx.actuator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "advstats")
public class AdvertiseCountCustomActuator {
	
	
private Map<String, List<String>> bugFixesByVersionMap = new HashMap<>();
	
	@PostConstruct
	public void init() {
		bugFixesByVersionMap.put("v1", Arrays.asList("Total no of advertises in database", "244"));
		bugFixesByVersionMap.put("v2", Arrays.asList("No of OPEN advertises", "234"));
		bugFixesByVersionMap.put("v2", Arrays.asList("No of advertises posted within last month", "2346"));
	}
	
	
	@ReadOperation 
	public List<String> findById(@Selector String id) {
		return this.bugFixesByVersionMap.get(id);
	}
	@ReadOperation
	public Map<String, List<String>> getAllBugFixes() {
		return this.bugFixesByVersionMap;
	}
}
