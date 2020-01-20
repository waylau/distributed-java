/**
 * Welcome to https://waylau.com
 */
package com.waylau.spring.mvc.vo;

/**
 * User.
 * 
 * @since 1.0.0 2018年2月10日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class User {
	private String username;
	private Integer age;

	public User(String username, Integer age) {
		this.username = username;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
