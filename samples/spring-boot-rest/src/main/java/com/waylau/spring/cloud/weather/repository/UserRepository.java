package com.waylau.spring.cloud.weather.repository;

import java.util.List;

import com.waylau.spring.cloud.weather.domain.User;

/**
 * 用户仓库.
 *
 * @since 1.0.0 2017年10月8日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public interface UserRepository {
	
	/**
	 * 新增或者修改用户
	 * 
	 * @param user
	 * @return
	 */
	User saveOrUpateUser(User user);

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	void deleteUser(Long id);

	/**
	 * 根据用户id获取用户
	 * 
	 * @param id
	 * @return
	 */
	User getUserById(Long id);

	/**
	 * 获取所有用户的列表
	 * 
	 * @return
	 */
	List<User> listUser();
}
