package com.cenfotec.guidservice.service;

import org.springframework.stereotype.Service;

import com.fasterxml.uuid.Generators;

@Service
public class GuidServiceImpl implements GuidService{
	
	public String generateGuid() {
		return Generators.randomBasedGenerator().generate().toString();
	}

}
