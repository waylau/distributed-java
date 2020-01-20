package com.waylau.spring.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waylau.spring.mvc.vo.User;


/**
 * Hello 控制器.
 * 
 * @since 1.0.0 2018年3月21日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
	    return "Hello World! Welcome to visit waylau.com!";
	}
	
	@RequestMapping("/hello/way")
	public User helloWay() {
	    return new User("Way Lau", 30);
	}
}
