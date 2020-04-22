package com.cenfotec.guidservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.guidservice.service.GuidService;


@RestController
@RequestMapping({ "/guid" })
public class GuidController {
	
	@Autowired
	private GuidService service;
	
	@GetMapping
	public String getGuid() {
		return service.generateGuid();
	}

}