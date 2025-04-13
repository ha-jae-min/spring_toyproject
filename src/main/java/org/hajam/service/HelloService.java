package org.hajam.service;

import org.hajam.mappers.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	private final TimeMapper timeMapper;
	
	@Autowired
	public HelloService(TimeMapper timeMapper) {
		this.timeMapper = timeMapper;
	}
	
	public String getTime() {
		return timeMapper.getTime();
	}

}
